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
    public final List<MathNode> getChildren() {
        return children;
    }

    @Override
    public final boolean isConstant() {
        return isConstant;
    }

    @Override
    public final double eval(VMap map) {
        if (children.isEmpty())
            throw new IllegalArgumentException("This operation node has no children");
        return operationEval(map);
    }

    abstract double operationEval(VMap map);

    @Override
    public final boolean simplify() {
        operationSimplify();
        sort();
        return isConstant = getChildren().stream().allMatch(MathNode::isConstant);
    }

    /**
     * Simplify and flatten operation children
     */
    abstract void operationSimplify();

    /**
     * Sort operation children by defined conventions
     */
    abstract void sort();

    /**
     * Returns the String version of an Operation
     *
     * @return operation as a String
     */
    abstract String operationToString();

    @Override
    public final String toString() {
        return operationToString();
    }
}
