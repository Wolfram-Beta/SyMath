package ca.wolfram.beta.symath.operations;

import ca.wolfram.beta.symath.MathNode;
import ca.wolfram.beta.symath.MathUtils;
import ca.wolfram.beta.symath.NodeType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Allan Wang on 2017-05-11.
 */
public class SubtractNode {

    private SubtractNode() {
    }

    /**
     * Links all children with subtract operations
     * If first node is 0, automatically creates a NegateNode with rest of contents
     *
     * @param nodes list of children
     * @return resulting MathNode
     * @throws IllegalArgumentException if nodes count < 2
     */
    public static MathNode create(List<MathNode> nodes) {
        NodeType.SUBTRACT.validateListSize(nodes);
        List<MathNode> toSubtract = nodes.subList(1, nodes.size());
        MathNode subtrahend;
        if (toSubtract.size() == 1) subtrahend = toSubtract.get(0);
        else subtrahend = AddNode.create(toSubtract);
        MathNode minuend = nodes.get(0);
        if (MathUtils.isZero(minuend)) return NegateNode.create(subtrahend);
        return AddNode.create(minuend, NegateNode.create(subtrahend));
    }

    public static MathNode create(MathNode... nodes) {
        return create(new ArrayList<>(Arrays.asList(nodes)));
    }

}
