package ca.wolfram.beta.symath;

import com.kotcrab.annotation.CallSuper;

import java.util.List;

public abstract class OperationNode implements MathNode {

    protected List<MathNode> children;
    private boolean isConstant = true;

    public OperationNode(List<MathNode> children) {
        this.children = children;
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
    public double eval() {
        if (children.isEmpty())
            throw new RuntimeException("This operation node has no children");
        return operationEval();
    }

    public abstract double operationEval();

    @Override
    @CallSuper
    public boolean simplify() {
        for (MathNode n : children)
            isConstant &= n.isConstant();
        return isConstant;
    }
}
