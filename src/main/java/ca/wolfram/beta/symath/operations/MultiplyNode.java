package ca.wolfram.beta.symath.operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ca.wolfram.beta.symath.MathNode;
import ca.wolfram.beta.symath.NodeType;
import ca.wolfram.beta.symath.VMap;

public class MultiplyNode extends OperationNode{

    MultiplyNode(List<MathNode> children) {
        super(children);
    }

    public static MathNode create(List<MathNode> nodes) {
        return new MultiplyNode(nodes);
    }

    public static MathNode create(MathNode... nodes) {
        return create(new ArrayList<>(Arrays.asList(nodes)));
    }

    @Override
    public NodeType getType() {
        return NodeType.MULTIPLY;
    }

    @Override
    public double operationEval(VMap map) {
        return  getChildren()
                .stream()
                .mapToDouble((n) -> n.eval(map))
                .reduce(1, (a, b) -> a * b);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("(");
        getChildren().forEach((c) -> s.append(c).append(" * "));
        return s.substring(0, s.length() - 3) + ")";
    }
}
