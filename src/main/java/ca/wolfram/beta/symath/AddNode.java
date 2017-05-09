package ca.wolfram.beta.symath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddNode extends OperationNode {

    private AddNode(List<MathNode> children) {
        super(children);
    }

    public static MathNode create(List<MathNode> nodes) {
        return new AddNode(nodes);
    }

    public static MathNode create(MathNode... nodes) {
        return new AddNode(new ArrayList<>(Arrays.asList(nodes)));
    }

    @Override
    public NodeType getType() {
        return NodeType.ADD;
    }

    @Override
    public boolean simplify() {
        super.simplify();
        //TODO add simplify
        return false;
    }

    @Override
    public double operationEval(Expression.VMap variableMap) {
        return getChildren()
                .stream()
                .mapToDouble((n) -> n.eval(variableMap))
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
