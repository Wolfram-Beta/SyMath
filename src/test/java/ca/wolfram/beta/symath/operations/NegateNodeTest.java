package ca.wolfram.beta.symath.operations;

import ca.wolfram.beta.symath.MathNode;
import ca.wolfram.beta.symath.NodeType;
import ca.wolfram.beta.symath.base.BaseNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class NegateNodeTest {
    @Test
    public void string() {
        MathNode negativeOne = NegateNode.create(BaseNode.create(1));
        assertEquals("Negate string should have a negative sign in front", "-1", negativeOne.toString());
    }

    @Test
    public void multiChildrenError() {
        try {
            PowerNode.create(BaseNode.create(1), BaseNode.create("x"), BaseNode.create("y"));
            fail("Multi children error not caught");
        } catch (IllegalArgumentException ex) {
            assertEquals("PowerNode's factory should throw an error", NodeType.POWER.getCountException(), ex.getMessage());
        }
    }

    @Test
    public void eval() {
        MathNode negativeOne = NegateNode.create(BaseNode.create(1));
        assertEquals(-1.0, negativeOne.eval(null), 0.001);
    }

    @Test
    public void simplify() {
        MathNode base = NegateNode.create(BaseNode.create(1));
        assertEquals(NodeType.CONSTANT, base.getType());
    }
}
