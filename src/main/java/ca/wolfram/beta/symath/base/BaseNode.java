package ca.wolfram.beta.symath.base;

import ca.wolfram.beta.symath.MathNode;

/**
 * Created by Allan Wang on 2017-05-06.
 * <p>
 * Static factory for creating base nodes
 */
public class BaseNode {

    public static MathNode
            ZERO = create(0L),
            ONE = create(1L);

    public static MathNode create(long n) {
        return new ConstantNode(n);
    }

    public static MathNode create(String s, double value) {
        return new MathConstantNode(s, value);
    }

    public static MathNode create(String s, boolean isConstant) {
        if (isConstant) return new MathConstantNode(s);
        return new VariableNode(s);
    }

    public static MathNode create(String s) {
        return new VariableNode(s);
    }
}
