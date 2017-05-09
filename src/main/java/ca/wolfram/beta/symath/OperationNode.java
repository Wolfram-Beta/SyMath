package ca.wolfram.beta.symath;

import com.kotcrab.annotation.CallSuper;

import java.util.List;

public abstract class OperationNode implements MathNode {

    List<MathNode> children;
    private boolean isConstant = true;

    OperationNode(List<MathNode> children) {
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
    public double eval(Expression.VMap variableMap) {
        if (children.isEmpty())
            throw new RuntimeException("This operation node has no children");
        return operationEval(variableMap);
    }

    public abstract double operationEval(Expression.VMap variableMap);

    @Override
    @CallSuper
    public boolean simplify() {
        for (MathNode n : children)
            isConstant &= n.isConstant();
        return isConstant;
    }
}
