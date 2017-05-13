package ca.wolfram.beta.symath.operations;

import ca.wolfram.beta.symath.MathNode;
import ca.wolfram.beta.symath.NodeType;
import ca.wolfram.beta.symath.VMap;
import ca.wolfram.beta.symath.base.BaseNode;

import java.util.Collections;
import java.util.List;

public class NegateNode extends OperationNode {

    private NegateNode(List<MathNode> children) {
        super(children);
    }

    /**
     * Takes a single node and wraps it with a negation
     *
     * @param node child
     * @return resulting MathNode
     */
    public static MathNode create(MathNode node) {
        if (node.getType() == NodeType.CONSTANT) return BaseNode.create((long) -node.eval(null));
        return new NegateNode(Collections.singletonList(node));
    }

    @Override
    public NodeType getType() {
        return NodeType.NEGATE;
    }

    @Override
    double operationEval(VMap map) {
        return -getChildren().get(0).eval(map);
    }

    @Override
    void operationSimplify() {
        //TODO is children contains operation node, expand it and bring the negation down?
    }

    @Override
    void sort() {
        // NegateNode only has one child and cannot be sorted
    }

    @Override
    String operationToString() {
        return String.format("-%s", getChildren().get(0).toString());
    }
}
