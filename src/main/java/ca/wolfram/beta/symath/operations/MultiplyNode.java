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

public class MultiplyNode extends OperationNode {

    private MultiplyNode(List<MathNode> children) {
        super(children);
    }

    public static MathNode create(List<MathNode> nodes) {
        return new MultiplyNode(nodes);
    }

    public static MathNode create(MathNode... nodes) {
        return create(new ArrayList<>(Arrays.asList(nodes)));
    }

    @Override
    public boolean simplify() {
        long constant = simplify(0, 1L);
        if (constant != 1L)
            getChildren().add(BaseNode.create(constant));
        return super.simplify();
    }

    /**
     * Helper method for simplification
     * Starts the listIterator at index, with history of constant, and continues from there
     * Extracts all constant integers and multiplies values to {@code constant}
     * If child is of type MULTIPLY, add its respective children to the current children and recursively simplify at the new index
     *
     * @param index    children index to start iteration
     * @param constant integer summation of child nodes before index
     * @return new integer product
     */
    private long simplify(int index, long constant) {
        List<MathNode> childrenToRaise = new ArrayList<>();
        final ListIterator<MathNode> each = getChildren().listIterator(index);
        while (each.hasNext()) {
            MathNode next = each.next();
            if (next.getType() == NodeType.MULTIPLY) {
                childrenToRaise.addAll(next.getChildren());
                each.remove();
                continue;
            }
            if (MathUtils.isReciprocal(next)) {
                double potential = constant / next.getChildren().get(0).eval(null);  // reduce precision loss
                if (potential == (long) potential) {
                    constant = (long) potential;  // next is division node and result is still an integer; merge
                    each.remove();
                    continue;
                }
            }
            if (MathUtils.isConstantInt(next)) {
                each.remove();
                constant *= next.eval(null);
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
    public NodeType getType() {
        return NodeType.MULTIPLY;
    }

    @Override
    public double operationEval(VMap map) {
        return getChildren()
                .stream()
                .mapToDouble((n) -> n.eval(map))
                .reduce(1, (a, b) -> a * b);
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
            s.append(" * ").append(c.toString());
        }
        return s.append(")").toString();
    }
}
