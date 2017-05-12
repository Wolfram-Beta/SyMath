package ca.wolfram.beta.symath.operations;

import ca.wolfram.beta.symath.MathNode;
import ca.wolfram.beta.symath.VMap;

import java.util.List;

public abstract class OperationNode implements MathNode {

    private List<MathNode> children;
    private boolean isConstant = true;

    /**
     * Base constructor for all operations
     *
     * @param children list of child nodes
     * @throws IllegalArgumentException if child count doesn't match specified argCount for the {@link #getType()}
     */
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
            throw new IllegalArgumentException("This operation node has no children");
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
