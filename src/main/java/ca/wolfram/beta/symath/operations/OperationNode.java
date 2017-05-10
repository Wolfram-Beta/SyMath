package ca.wolfram.beta.symath.operations;

import ca.wolfram.beta.symath.MathNode;
import ca.wolfram.beta.symath.VMap;

import java.util.List;

public abstract class OperationNode implements MathNode {

    List<MathNode> children;
    private boolean isConstant = true;

    OperationNode(List<MathNode> children) {
        getType().validateListSize(children);
        this.children = children;
        simplify();
    }

    @Override
    public List<MathNode> getChildren() {
        return children;
    }

    @Override
    public boolean isConstant() {
        return isConstant;
    }

    @Override
    public double eval(VMap map) {
        if (children.isEmpty())
            throw new RuntimeException("This operation node has no children");
        return operationEval(map);
    }

    public abstract double operationEval(VMap map);

    @Override
    public boolean simplify() {
        for (MathNode n : children)
            isConstant &= n.isConstant();
        return isConstant;
    }
}
