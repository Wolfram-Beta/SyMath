package ca.wolfram.beta.symath;

import java.util.List;
import java.util.Map;

/**
 * Created by Allan Wang on 2017-05-06.
 */
public class MathConstantNode implements MathNode {

    private final String variable;

    MathConstantNode(String variable, double value) {
        this.variable = variable;
        VariableMap.getMap().put(variable, value);
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
    public double eval() {
        return VariableMap.getMap().get(variable, 0);
    }

    @Override
    public boolean simplify() {
        //already simplified and is a constant
        return true;
    }
}
