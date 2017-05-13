package ca.wolfram.beta.symath.operations;

import ca.wolfram.beta.symath.MathNode;
import ca.wolfram.beta.symath.MathUtils;
import ca.wolfram.beta.symath.NodeType;
import ca.wolfram.beta.symath.VMap;
import ca.wolfram.beta.symath.base.BaseNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Node that will sum all of its children
 * <p>
 * Given {@link #simplify()}, the constant integer values will always be last
 */
public class AddNode extends OperationNode {

    private AddNode(List<MathNode> children) {
        super(children);
    }

    /**
     * Links all children with add operations
     *
     * @param nodes list of children
     * @return resulting MathNode
     * @throws IllegalArgumentException if nodes count < 2
     */
    public static MathNode create(List<MathNode> nodes) {
        return new AddNode(nodes);
    }

    public static MathNode create(MathNode... nodes) {
        return create(new ArrayList<>(Arrays.asList(nodes)));
    }

    @Override
    public NodeType getType() {
        return NodeType.ADD;
    }

    @Override
    void operationSimplify() {
        long constant = simplify(0, 0L);
        if (constant != 0L)
            getChildren().add(BaseNode.create(constant));
    }

    @Override
    void sort() {
        //TODO
    }

    /**
     * Helper method for simplification
     * Starts the listIterator at index, with history of constant, and continues from there
     * Extracts all constant integers and adds values to {@code constant}
     * If child is of type ADD, add its respective children to the current children and recursively simplify at the new index
     *
     * @param index    children index to start iteration
     * @param constant integer summation of child nodes before index
     * @return new integer summation
     */
    private long simplify(int index, long constant) {
        List<MathNode> childrenToRaise = new ArrayList<>();
        final ListIterator<MathNode> iter = getChildren().listIterator(index);
        while (iter.hasNext()) {
            MathNode next = iter.next();
            if (next.getType() == NodeType.ADD) {
                childrenToRaise.addAll(next.getChildren());
                iter.remove();
                continue;
            }
            if (MathUtils.isConstantInt(next)) {
                iter.remove();
                constant += next.eval(null);
            }
        }
        if (!childrenToRaise.isEmpty()) {
            int last = getChildren().size();
            getChildren().addAll(childrenToRaise);
            return simplify(last, constant);
        }
        return constant;
    }

    @Override
    double operationEval(VMap map) {
        return getChildren()
                .stream()
                .mapToDouble((n) -> n.eval(map))
                .sum();
    }

    @Override
    String operationToString() {
        StringBuilder s = new StringBuilder().append("(");
        ListIterator<MathNode> iter = getChildren().listIterator();
        if (iter.hasNext()) s.append(iter.next().toString());
        while (iter.hasNext()) {
            MathNode c = iter.next();
            if ((c.getType() == NodeType.NEGATE) || (c.getType() == NodeType.CONSTANT && c.eval(null) < 0))
                s.append(" - ").append(c.toString().substring(1));
            else
                s.append(" + ").append(c.toString());
        }
        return s.append(")").toString();
    }
}
