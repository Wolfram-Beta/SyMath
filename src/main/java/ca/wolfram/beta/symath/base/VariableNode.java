package ca.wolfram.beta.symath.base;

import ca.wolfram.beta.symath.MathNode;
import ca.wolfram.beta.symath.NodeType;
import ca.wolfram.beta.symath.VMap;

import java.util.List;

/**
 * Created by Allan Wang on 2017-05-06.
 * <p>
 * Node holding a variable
 */
public class VariableNode implements MathNode {

    private final String variable;

    VariableNode(String variable) {
        this.variable = variable;
    }

    @Override
    public NodeType getType() {
        return NodeType.VARIABLE;
    }

    @Override
    public List<MathNode> getChildren() {
        throw new UnsupportedOperationException("VariableNode will never have children!");
    }

    @Override
    public boolean isConstant() {
        return false;
    }

    @Override
    public double eval(VMap map) {
        return map.get(variable, 0);
    }

    @Override
    public String toString() {
        return variable;
    }

    @Override
    public boolean simplify() {
        //already simplified; isn't a constant
        return false;
    }
}
