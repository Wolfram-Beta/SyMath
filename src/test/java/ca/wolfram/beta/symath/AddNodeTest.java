package ca.wolfram.beta.symath;

import org.junit.Test;

import static org.junit.Assert.*;

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
