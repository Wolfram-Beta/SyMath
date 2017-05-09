package ca.wolfram.beta.symath;

import ca.wolfram.beta.symath.base.BaseNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Allan Wang on 2017-05-09.
 */
public class MathUtilsTest {

    @Test
    public void isInt() {
        assertTrue("3 is an int", MathUtils.isConstantInt(BaseNode.create(3)));
        assertTrue("2 is an int", MathUtils.isConstantInt(BaseNode.create("a", 2)));
        assertFalse("PI is not an int", MathUtils.isConstantInt(BaseNode.create("PI", Math.PI)));
        assertFalse("x is not an int", MathUtils.isConstantInt(BaseNode.create("x")));
    }
}
