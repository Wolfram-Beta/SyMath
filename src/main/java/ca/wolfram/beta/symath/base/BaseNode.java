package ca.wolfram.beta.symath.base;

import ca.wolfram.beta.symath.Expression;
import ca.wolfram.beta.symath.MathNode;

/**
 * Created by Allan Wang on 2017-05-06.
 * <p>
 * Static factory for creating base nodes
 */
public class BaseNode {

    public static MathNode
            ZERO = create(0),
            ONE = create(1);

    public static MathNode create(int i) {
        return new ConstantNode(i);
    }

    public static MathNode create(String s, double value, Expression exp) {
        return new MathConstantNode(s, value, exp);
    }

    public static MathNode create(String s) {
        return new VariableNode(s);
    }
}
