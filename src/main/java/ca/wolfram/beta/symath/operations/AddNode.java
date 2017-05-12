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
    public boolean simplify() {
        long constant = simplify(0, 0L);
        if (constant != 0L)
            getChildren().add(BaseNode.create(constant));
        return super.simplify();
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
        final ListIterator<MathNode> each = getChildren().listIterator(index);
        while (each.hasNext()) {
            MathNode next = each.next();
            if (next.getType() == NodeType.ADD) {
                childrenToRaise.addAll(next.getChildren());
                each.remove();
                continue;
            }
            if (MathUtils.isConstantInt(next)) {
                each.remove();
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
    public double operationEval(VMap map) {
        return getChildren()
                .stream()
                .mapToDouble((n) -> n.eval(map))
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("(");
        boolean isFirst = true;
        for (MathNode c : getChildren()) {
            if (isFirst) {
                s.append(c.toString());
                isFirst = false;
                continue;
            }
            if ((c.getType() == NodeType.NEGATE) || (c.getType() == NodeType.CONSTANT) && c.eval(null) < 0)
                s.append(" - ").append(c.toString().substring(1));
            else
                s.append(" + ").append(c.toString());
        }
        return s.append(")").toString();
    }
}
