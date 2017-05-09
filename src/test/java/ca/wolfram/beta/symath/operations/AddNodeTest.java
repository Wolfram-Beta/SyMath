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
        MathNode sum = AddNode.create(BaseNode.create(1), BaseNode.create("x"), BaseNode.create("y"));
        assertEquals("Sum string should be concatenated values surrounded by brackets", "(1 + x + y)", sum.toString());
    }
}
