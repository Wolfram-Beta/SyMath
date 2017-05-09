package ca.wolfram.beta.symath.operations;

import ca.wolfram.beta.symath.MathNode;
import ca.wolfram.beta.symath.base.BaseNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class NegateNodeTest {
    @Test
    public void string() {
        MathNode negativeOne = NegateNode.create(BaseNode.create(1));
        assertEquals("Negate string should have a negative sign in front", "- 1", negativeOne.toString());
    }

    @Test
    public void multiChildrenError() {
        try {
            NegateNode.create(BaseNode.create(1), BaseNode.create("x"), BaseNode.create("y"));
            fail("Multi children error not caught");
        } catch (RuntimeException ex) {
            assertEquals("NegateNode's factory should throw an error", "Negate Node only takes 1 node", ex.getMessage());
        }
    }
}
