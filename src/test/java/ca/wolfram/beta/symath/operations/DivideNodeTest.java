package ca.wolfram.beta.symath.operations;

import ca.wolfram.beta.symath.MathNode;
import ca.wolfram.beta.symath.base.BaseNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Allan Wang on 2017-05-11.
 */
public class DivideNodeTest {

    @Test
    public void eval() {
        assertEquals("1/2 = 0.5", 0.5, DivideNode.create(2).eval(null), 0.001);
    }

    @Test
    public void string() {
        assertEquals("1/2", "(1/2)", DivideNode.create(2).toString());
    }

    @Test
    public void complexString() {
        MathNode divide = DivideNode.create(AddNode.create(BaseNode.create("x"), BaseNode.create(2)));
        assertEquals("(1/(x + 2))", "(1/(x + 2))", divide.toString());
    }

    @Test
    public void divideByZero() {
        try {
            DivideNode.create(0);
            fail("Division by 0 was not caught");
        } catch (NumberFormatException e) {
            assertEquals("Divide by 0 error should be thrown", "Cannot have 0 on the denominator: (1/0)", e.getMessage());
        }
    }

}
