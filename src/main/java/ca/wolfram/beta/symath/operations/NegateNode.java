package ca.wolfram.beta.symath.operations;

import ca.wolfram.beta.symath.MathNode;
import ca.wolfram.beta.symath.NodeType;
import ca.wolfram.beta.symath.VMap;
import ca.wolfram.beta.symath.base.BaseNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NegateNode extends OperationNode {

    private NegateNode(List<MathNode> children) {
        super(children);
    }

    public static MathNode create(List<MathNode> nodes) {
        if (nodes.size() > 1) throw new RuntimeException("Negate Node only takes 1 node");
        MathNode n = nodes.get(0);
        if (n.getType() == NodeType.CONSTANT) return BaseNode.create((long) -n.eval(null));
        return new NegateNode(nodes);
    }

    public static MathNode create(MathNode... nodes) {
        return create(new ArrayList<>(Arrays.asList(nodes)));
    }

    @Override
    public NodeType getType() {
        return NodeType.NEGATE;
    }

    @Override
    public double operationEval(VMap map) {
        return -getChildren().get(0).eval(map);
    }

    @Override
    public String toString() {
        return String.format("-%s", getChildren().get(0).toString());
    }
}
