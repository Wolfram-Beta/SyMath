package ca.wolfram.beta.symath.operations;

import ca.wolfram.beta.symath.MathNode;
import ca.wolfram.beta.symath.base.BaseNode;

/**
 * Created by Allan Wang on 2017-05-11.
 */
public class DivideNode {

    private DivideNode() {
    }

    /**
     * Takes in a single node to divide by (dividend == 1)
     *
     * @param node divisor
     * @return resulting node
     */
    public static MathNode create(MathNode node) {
        return PowerNode.create(node, BaseNode.create(-1));
    }

    public static MathNode create(long value) {
        return create(BaseNode.create(value));
    }
}
