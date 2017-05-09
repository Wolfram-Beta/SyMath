package ca.wolfram.beta.symath.operations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import ca.wolfram.beta.symath.MathNode;
import ca.wolfram.beta.symath.base.BaseNode;

public class PowerNodeTest {
    @Test
    public void string() {
        MathNode power = PowerNode.create(BaseNode.create(2), BaseNode.create(3));
        assertEquals("Power string should be in the form of (a ^ b)", "(2 ^ 3)", power.toString());
    }

    @Test
    public void multiChildrenError() {
        try {
            PowerNode.create(BaseNode.create(1), BaseNode.create("x"), BaseNode.create("y"));
            fail("Multi children error not caught");
        } catch (RuntimeException ex) {
            assertEquals("PowerNode's factory method should throw an error", "Power Node takes exactly 2 node", ex.getMessage());
        }
    }

    @Test
    public void eval() {
        MathNode power = PowerNode.create(BaseNode.create(3), BaseNode.create(2));
        assertEquals(9.0, power.eval(null), 0.001);
    }
}
