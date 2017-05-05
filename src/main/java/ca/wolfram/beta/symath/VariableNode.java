package ca.wolfram.beta.symath;

import java.util.List;
import java.util.Map;

/**
 * Created by Allan Wang on 2017-05-06.
 */
public class VariableNode implements MathNode {

    private final String variable;
    private final Map<String, Double> variableMap;

    VariableNode(String variable) {
        this.variable = variable;
        this.variableMap = VariableMap.getMap();
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
    public double eval() {
        return variableMap.containsKey(variable) ? variableMap.get(variable) : 0;
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
