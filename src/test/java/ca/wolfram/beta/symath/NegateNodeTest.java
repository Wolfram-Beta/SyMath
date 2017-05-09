package ca.wolfram.beta.symath;

import static org.junit.Assert.*;

import org.junit.Test;

public class NegateNodeTest {
    @Test
    public void string() {
        MathNode negativeOne = NegateNode.create(BaseNode.create(1));
        assertEquals("Negate string should have a negative sign in front", "- 1", negativeOne.toString());
    }
    
    @Test
    public void multiChildrenError() {
    	try {
            @SuppressWarnings("unused")
			MathNode error = NegateNode.create(BaseNode.create(1), BaseNode.create("x"), BaseNode.create("y"));
            fail("Multi children error not caught");
    	}
    	catch (RuntimeException ex) {
            assertEquals("Negate did not throw error for multiple children", "Negate Node only takes 1 node", ex.getMessage());

    	}
    }

	@Test
    public void eval() {
        MathNode negativeOne = NegateNode.create(BaseNode.create(1));
        assertEquals(-1.0, negativeOne.eval(null), 0.001);
    }
}