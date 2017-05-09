package ca.wolfram.beta.symath.base;

import ca.wolfram.beta.symath.MathNode;
import ca.wolfram.beta.symath.NodeType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Allan Wang on 2017-05-09.
 */
public class MathConstantNodeTest {

    private MathNode pi;

    @Before
    public void init() {
        pi = BaseNode.create("PI", Math.PI);
    }

    @Test
    public void string() {
        assertEquals("String should say PI", "PI", pi.toString());
    }

    @Test
    public void eval() {
        assertEquals("PI should have the same value as Math.PI", Math.PI, pi.eval(null), 0.0001);
    }

    @Test
    public void type() {
        assertEquals("PI is a MathConstant", NodeType.MATHCONSTANT, pi.getType());
    }

    @Test
    public void constant() {
        assertTrue("PI is a constant", pi.isConstant());
        assertTrue("PI is a constant", pi.simplify());
    }
}
