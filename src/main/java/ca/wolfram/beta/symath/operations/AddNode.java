package ca.wolfram.beta.symath.operations;

import ca.wolfram.beta.symath.*;
import ca.wolfram.beta.symath.base.BaseNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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

    @Override
    public boolean simplify() {
        int constant = 0;
        final Iterator<MathNode> each = getChildren().iterator();
        while (each.hasNext()) {
            MathNode next = each.next();
            if (!next.isConstant() || !MathUtils.isInt(next)) continue;
            each.remove();
            constant += next.eval(Expression.getConstantMap());
        }
        MathNode newConstant = BaseNode.create(constant);
        getChildren().add(newConstant);
        return super.simplify();
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
        getChildren().forEach((c) -> s.append(c).append(" + "));
        return s.substring(0, s.length() - 3) + ")";
    }
}
