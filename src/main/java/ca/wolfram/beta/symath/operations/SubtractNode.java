package ca.wolfram.beta.symath.operations;

import ca.wolfram.beta.symath.MathNode;
import ca.wolfram.beta.symath.base.BaseNode;

/**
 * Created by Allan Wang on 2017-05-11.
 */
public class SubtractNode {

    private SubtractNode() {
    }

    /**
     * Takes in a single node to subtract (minuend == 0)
     *
     * @param node subtrahend
     * @return resulting node
     */
    public static MathNode create(MathNode node) {
        return AddNode.create(NegateNode.create(node));
    }

    public static MathNode create(long value) {
        return create(BaseNode.create(value));
    }

}
