package ca.wolfram.beta.symath.operations;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.wolfram.beta.symath.MathNode;
import ca.wolfram.beta.symath.base.BaseNode;

public class MultiplyNodeTest {
    @Test
    public void string() {
        MathNode multiply = MultiplyNode.create(BaseNode.create("x"), BaseNode.create("y"),BaseNode.create(1));
        assertEquals("Multiply string should be concatenated values surrounded by brackets", "(x * y * 1)", multiply.toString());
    }

	@Test
    public void eval() {
        MathNode multiply = MultiplyNode.create(BaseNode.create(2), BaseNode.create(3));
        assertEquals(6.0, multiply.eval(null), 0.001);
    }
}
