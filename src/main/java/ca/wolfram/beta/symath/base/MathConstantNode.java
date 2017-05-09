package ca.wolfram.beta.symath.base;

import ca.wolfram.beta.symath.Expression;
import ca.wolfram.beta.symath.MathNode;
import ca.wolfram.beta.symath.NodeType;
import ca.wolfram.beta.symath.VMap;

import java.util.List;

/**
 * Created by Allan Wang on 2017-05-06.
 * <p>
 * Node holding a math constant
 */
public class MathConstantNode implements MathNode {

    private final String variable;

    MathConstantNode(String variable, double value) {
        Expression.getConstantMap().put(variable, value);
        this.variable = variable;
    }

    @Override
    public NodeType getType() {
        return NodeType.MATHCONSTANT;
    }

    @Override
    public List<MathNode> getChildren() {
        throw new UnsupportedOperationException("MathConstantNode will never have children!");
    }

    @Override
    public boolean isConstant() {
        return true;
    }

    @Override
    public String toString() {
        return variable;
    }

    @Override
    public double eval(VMap map) {
        return map.get(variable, String.format("%s has not yet been defined in the constant map", variable));
    }

    @Override
    public boolean simplify() {
        //already simplified and is a constant
        return true;
    }
}
