package ca.wolfram.beta.symath.operations;

import ca.wolfram.beta.symath.MathNode;
import ca.wolfram.beta.symath.base.BaseNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Allan Wang on 2017-05-06.
 */
public class AddNodeTest {

    @Test
    public void string() {
        MathNode sum = AddNode.create(BaseNode.create("x"), BaseNode.create("y"), BaseNode.create(1));
        assertEquals("Sum string should be concatenated values surrounded by brackets", "(x + y + 1)", sum.toString());
    }

    @Test
    public void negativeString() {
        assertEquals("(x + y - 1)", AddNode.create(BaseNode.create("x"), BaseNode.create("y"), BaseNode.create(-1)).toString());
        assertEquals("(-x + y)", AddNode.create(NegateNode.create(BaseNode.create("x")), BaseNode.create("y")).toString());
    }

    @Test
    public void simplify() {
        MathNode sum = AddNode.create(BaseNode.create(2), BaseNode.create("x"), BaseNode.create(3), BaseNode.create("PI", Math.PI));
        assertEquals("Simplification should be (x + PI + 5)", "(x + PI + 5)", sum.toString());
    }
}
