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
    public void validateBaseNode() {
        List<MathNode> list = new ArrayList<>();
        NodeType.VARIABLE.validateListSize(list); //no error should be thrown
        list.add(BaseNode.create("x"));
        try {
            NodeType.VARIABLE.validateListSize(list);
            fail("Variable did not throw exception for list of size " + list.size());
        } catch (IllegalArgumentException e) {
            assertEquals("Variable Node should throw an IllegalArgumentException", NodeType.VARIABLE.getCountException(), e.getMessage());
        }
    }

    @Test
    public void validateAddTwoVars() {
        List<MathNode> list = new ArrayList<>();
        list.add(BaseNode.create("x"));
        list.add(BaseNode.create(1));
        NodeType.ADD.validateListSize(list); //no error should be thrown
    }

    @Test
    public void validateAddOneVar() {
        List<MathNode> list = new ArrayList<>();
        list.add(BaseNode.create("x"));
        try {
            NodeType.ADD.validateListSize(list);
            fail("Add did not throw exception for list of size " + list.size());
        } catch (IllegalArgumentException e) {
            assertEquals("Add Node should throw an IllegalArgumentException", NodeType.ADD.getCountException(), e.getMessage());
        }
    }

    @Test
    public void validatePowerOneVar() {
        List<MathNode> list = new ArrayList<>();
        list.add(BaseNode.create("x"));
        try {
            NodeType.POWER.validateListSize(list);
            fail("Power did not throw exception for list of size " + list.size());
        } catch (IllegalArgumentException e) {
            assertEquals("Power Node should throw an IllegalArgumentException", NodeType.POWER.getCountException(), e.getMessage());
        }
    }
}
