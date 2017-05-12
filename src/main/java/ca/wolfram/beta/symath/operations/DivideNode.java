package ca.wolfram.beta.symath.operations;

import ca.wolfram.beta.symath.MathNode;
import ca.wolfram.beta.symath.MathUtils;
import ca.wolfram.beta.symath.NodeType;
import ca.wolfram.beta.symath.base.BaseNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Allan Wang on 2017-05-11.
 */
public class DivideNode {

    private DivideNode() {
    }

    /**
     * Links all children with divide operations
     * If first node is 1, automatically creates a PowerNode with an exponent == -1
     *
     * @param nodes list of children
     * @return resulting MathNode
     * @throws IllegalArgumentException if nodes count < 2
     */
    public static MathNode create(List<MathNode> nodes) {
        NodeType.DIVIDE.validateListSize(nodes);
        List<MathNode> toDivide = nodes.subList(1, nodes.size());
        MathNode divisor;
        if (toDivide.size() == 1) divisor = toDivide.get(0);
        else divisor = MultiplyNode.create(toDivide);
        MathNode dividend = nodes.get(0);
        if (MathUtils.isOne(dividend)) return PowerNode.create(divisor, BaseNode.create(-1));
        return MultiplyNode.create(dividend, PowerNode.create(divisor, BaseNode.create(-1)));
    }

    public static MathNode create(MathNode... nodes) {
        return create(new ArrayList<>(Arrays.asList(nodes)));
    }
}
