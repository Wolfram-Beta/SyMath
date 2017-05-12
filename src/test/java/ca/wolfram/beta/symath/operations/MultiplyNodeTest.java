package ca.wolfram.beta.symath.operations;

import ca.wolfram.beta.symath.MathNode;
import ca.wolfram.beta.symath.base.BaseNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultiplyNodeTest {
    @Test
    public void string() {
        MathNode multiply = MultiplyNode.create(BaseNode.create(2), BaseNode.create("x"), BaseNode.create("y"));
        assertEquals("Multiply string should be concatenated values surrounded by brackets", "(x * y * 2)", multiply.toString());
    }

    @Test
    public void simplify() {
        MathNode multiply = MultiplyNode.create(BaseNode.create(2), BaseNode.create("x"), BaseNode.create(3));
        assertEquals("2 * x * 3 = x * 6", "(x * 6)", multiply.toString());
    }

    @Test
    public void constantOne() {
        MathNode multiply = MultiplyNode.create(BaseNode.create(1), BaseNode.create("x"));
        assertEquals("1 * x = x", "(x)", multiply.toString());
    }

    @Test
    public void eval() {
        MathNode multiply = MultiplyNode.create(BaseNode.create(2), BaseNode.create(3));
        assertEquals(6.0, multiply.eval(null), 0.001);
    }
}
