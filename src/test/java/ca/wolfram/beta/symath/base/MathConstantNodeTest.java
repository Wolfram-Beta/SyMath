package ca.wolfram.beta.symath.base;

import ca.wolfram.beta.symath.Expression;
import ca.wolfram.beta.symath.MathNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Allan Wang on 2017-05-09.
 */
public class MathConstantNodeTest {

    @Test
    public void pi() {
        Expression expression = new Expression(); //TODO watch our for constructor changes
        MathNode constant = BaseNode.create("PI", Math.PI, expression);
        assertEquals("String should say PI", "PI", constant.toString());
        assertEquals("PI should have the same value as Math.PI", Math.PI, constant.eval(expression.getMap()), 0.0001);
    }
}
