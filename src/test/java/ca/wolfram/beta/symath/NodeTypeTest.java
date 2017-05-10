package ca.wolfram.beta.symath;

import ca.wolfram.beta.symath.base.BaseNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Allan Wang on 2017-05-09.
 */
public class NodeTypeTest {

    @Test
    public void names() {
        assertEquals("PowerNode", NodeType.POWER.getName());
        assertEquals("MathConstantNode", NodeType.MATH_CONSTANT.getName());
    }

    @Test
    public void validate() {
        List<MathNode> list = new ArrayList<>();
        list.add(BaseNode.create(0));
        NodeType.ADD.validateListSize(list); //no error should be thrown
        try {
            NodeType.POWER.validateListSize(list);
            fail("Power did not throw exception for list of size " + list.size());
        } catch (IllegalArgumentException e) {
            assertEquals("Power Node should thrown an IllegalArgumentException", NodeType.POWER.getCountException(), e.getMessage());
        }
    }
}
