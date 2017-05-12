package ca.wolfram.beta.symath.operations;

import ca.wolfram.beta.symath.MathNode;
import ca.wolfram.beta.symath.MathUtils;
import ca.wolfram.beta.symath.NodeType;
import ca.wolfram.beta.symath.VMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerNode extends OperationNode {

    private PowerNode(List<MathNode> children) {
        super(children);
        if (MathUtils.isNegativeConstant(getChildren().get(1)) && MathUtils.isZero(getChildren().get(0)))
            throw new NumberFormatException(String.format("Cannot have 0 on the denominator: %s", toString()));
    }

    /**
     * Index 0 is the base and Index 1 is the power.
     *
     * @throws IllegalArgumentException if number of nodes is incorrect.
     */
    public static MathNode create(List<MathNode> nodes) {
        return new PowerNode(nodes);
    }

    public static MathNode create(MathNode... nodes) {
        return create(new ArrayList<>(Arrays.asList(nodes)));
    }

    @Override
    public boolean simplify() {
        //TODO
        return super.simplify();
    }

    @Override
    public NodeType getType() {
        return NodeType.POWER;
    }

    @Override
    public double operationEval(VMap map) {
        return Math.pow(getChildren().get(0).eval(map), getChildren().get(1).eval(map));
    }

    @Override
    public String toString() {
        if (MathUtils.isReciprocal(this)) return String.format("(1/%s)", getChildren().get(0).toString());
        return String.format("(%s ^ %s)", getChildren().get(0).toString(), getChildren().get(1).toString());
    }

}
