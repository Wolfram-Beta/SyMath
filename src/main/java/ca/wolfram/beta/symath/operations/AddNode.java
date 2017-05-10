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

    /**
     * Extracts all constant integers and appends it as one {@link ca.wolfram.beta.symath.base.ConstantNode} if the sum != 0
     * Flattens children if they are also of type ADD
     *
     * @return true is isConstant, false otherwise
     */
    @Override
    public boolean simplify() {
        int constant = simplify(0, 0);
        if (constant != 0)
            children.add(BaseNode.create(constant));
        return super.simplify();
    }

    private int simplify(int index, int constant) {
        List<MathNode> childrenToRaise = new ArrayList<>(); //children to be flattened to this node level
        final ListIterator<MathNode> each = getChildren().listIterator(index); //start iteration and last checked index
        while (each.hasNext()) {
            MathNode next = each.next();
            if (next.getType() == NodeType.ADD) {
                childrenToRaise.addAll(next.getChildren());
                each.remove();
                continue;
            }
            if (!next.isConstant() || !MathUtils.isConstantInt(next)) continue;
            each.remove();
            constant += next.eval(null);
        }
        if (!childrenToRaise.isEmpty()) {
            int last = children.size();
            children.addAll(childrenToRaise);
            return simplify(last, constant); //recurse and return total constant sum
        }
        return constant; //done simplification; return sum
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
                s.append(c);
                isFirst = false;
                continue;
            }
            if (c.getType() == NodeType.NEGATE || (c.getType() == NodeType.CONSTANT) && c.eval(null) < 0)
                s.append(" - ").append(c.toString().substring(1));
            else
                s.append(" + ").append(c);
        }
        return s.append(")").toString();
    }
}
