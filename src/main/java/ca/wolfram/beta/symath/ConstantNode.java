package ca.wolfram.beta.symath;

import java.util.List;

/**
 * Created by Allan Wang on 2017-05-06.
 */
public class ConstantNode implements MathNode {

    private final int constant;

    ConstantNode(int constant) {
        this.constant = constant;
    }

    @Override
    public NodeType getType() {
        return NodeType.CONSTANT;
    }

    @Override
    public List<MathNode> getChildren() {
        throw new UnsupportedOperationException("ConstantNode will never have children!");
    }

    @Override
    public boolean isConstant() {
        return true;
    }

    @Override
    public double eval() {
        return (double) constant;
    }

    @Override
    public boolean simplify() {
        //already simplified and is a constant
        return true;
    }

    @Override
    public String toString() {
        return Integer.toString(constant);
    }
}
