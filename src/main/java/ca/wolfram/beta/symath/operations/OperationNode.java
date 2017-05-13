package ca.wolfram.beta.symath.operations;

import ca.wolfram.beta.symath.MathNode;
import ca.wolfram.beta.symath.NodeType;
import ca.wolfram.beta.symath.VMap;

import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.function.BiFunction;

public abstract class OperationNode implements MathNode {

    private List<MathNode> children;
    private boolean isConstant = true;
    private static EnumMap<NodeType, Comparator<MathNode>> comparatorMap = new EnumMap<>(NodeType.class);

    /**
     * Base constructor for all operations
     *
     * @param children list of child nodes
     * @throws IllegalArgumentException if child count doesn't match specified argCount for the {@link #getType()}
     */
    OperationNode(List<MathNode> children) {
        getType().validateListSize(children);
        this.children = children;
        simplify();
    }

    @Override
    public final List<MathNode> getChildren() {
        return children;
    }

    @Override
    public final boolean isConstant() {
        return isConstant;
    }

    @Override
    public final double eval(VMap map) {
        if (children.isEmpty())
            throw new IllegalArgumentException("This operation node has no children");
        return operationEval(map);
    }

    abstract double operationEval(VMap map);

    @Override
    public final boolean simplify() {
        operationSimplify();
        if (getType().sortable)
            getChildren().sort(getComparator(getType()));
        return isConstant = getChildren().stream().allMatch(MathNode::isConstant);
    }

    private Comparator<MathNode> getComparator(NodeType type) {
        if (comparatorMap.containsKey(type)) return comparatorMap.get(type);
        Comparator<MathNode> comparator = getComparator();
        comparatorMap.put(type, comparator);
        return comparator;
    }

    /**
     * Comparator retrieval
     * Will be overridden by nodes that allow sorting
     *
     * @return Comparator
     */
    Comparator<MathNode> getComparator() {
        throw new RuntimeException(String.format("getComparator() not yet implemented for %s", getType().getName()));
    }

    /**
     * Helper function to compare two MathNodes
     * Applies match conditions both in order and in reverse order
     *
     * @param n1      first node
     * @param n2      second node
     * @param match   filter to see if comparison is valid
     * @param compare to retrieve comparison
     * @return comparison value if matched; null otherwise
     */
    Integer compare(MathNode n1, MathNode n2, BiFunction<MathNode, MathNode, Boolean> match, BiFunction<MathNode, MathNode, Integer> compare) {
        if (match.apply(n1, n2)) return compare.apply(n1, n2);
        if (match.apply(n2, n1)) return -compare.apply(n2, n1);
        return null;
    }

    /**
     * Simplify and flatten operation children
     */
    abstract void operationSimplify();

    /**
     * Returns the String version of an Operation
     *
     * @return operation as a String
     */
    abstract String operationToString();

    @Override
    public final String toString() {
        return operationToString();
    }
}
