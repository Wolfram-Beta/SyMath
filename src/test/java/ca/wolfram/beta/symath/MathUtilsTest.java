package ca.wolfram.beta.symath;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import ca.wolfram.beta.symath.base.BaseNode;
import ca.wolfram.beta.symath.operations.MultiplyNode;

/**
 * Created by Allan Wang on 2017-05-09.
 */
public class MathUtilsTest {

    private final static MathNode two = BaseNode.create(2l);
    private final static MathNode three = BaseNode.create(3l);

    private final static MathNode variableX = BaseNode.create("x");
    private final static MathNode variableY = BaseNode.create("y");

    private final static MathNode constantTwo = BaseNode.create("a", 2);
    private final static MathNode constantPi = BaseNode.create("PI", Math.PI);

    @Test
    public void isConstantInt() {
        assertTrue("3 is an int", MathUtils.isConstantInt(three));
        assertTrue("2 is an int", MathUtils.isConstantInt(constantTwo));
        assertFalse("PI is not an int", MathUtils.isConstantInt(constantPi));
        assertFalse("x is not an int", MathUtils.isConstantInt(variableX));
    }

    @Test
    public void noVariableTerms() {
        assertEquals("There should be no Variable terms on a constant", 0, MathUtils.getVariableTerms(three).size());
    }

    @Test
    public void getVariableTerms() {
        MathNode threeXY = MultiplyNode.create(three, variableX, variableY);
        Set<MathNode> variables = MathUtils.getVariableTerms(threeXY);
        assertEquals("the size of the set is incorrect", 2, variables.size());
        assertTrue("x should have been in the set", variables.contains(variableX));
        assertTrue("y should have been in the set", variables.contains(variableY));
    }

    @Test
    public void isLikeTerm() {
        MathNode threeXY = MultiplyNode.create(three, variableX, variableY);
        MathNode twoXY = MultiplyNode.create(two, variableX, variableY);
        assertTrue("These should have been like terms", MathUtils.isLikeTerm(threeXY, twoXY));
    }

    @Test
    public void isNotLikeTerm() {
        MathNode threeXY = MultiplyNode.create(three, variableX, variableY);
        MathNode twoX = MultiplyNode.create(two, variableX);
        assertFalse("These should not have been like terms", MathUtils.isLikeTerm(threeXY, twoX));
    }

    @Test
    public void groupByLikeTerms() {
        MathNode threeXY = MultiplyNode.create(three, variableX, variableY);
        MathNode twoXY = MultiplyNode.create(two, variableX, variableY);
        MathNode twoX = MultiplyNode.create(two, variableX);
        List<MathNode> nodeList =  Arrays.asList(two, threeXY, three, twoX, twoXY);
        Map<Set<MathNode>, List<MathNode>> groupby = MathUtils.groupByLikeTerms(nodeList);
        assertEquals("The amount of groups is incorrect", 3, groupby.size());
        Set<MathNode> noVars = MathUtils.getVariableTerms(two);
        Set<MathNode> justX = MathUtils.getVariableTerms(twoX);
        Set<MathNode> xy = MathUtils.getVariableTerms(threeXY);
        assertTrue("The map should contain this key", groupby.containsKey(noVars));
        assertTrue("The map should contain this key", groupby.containsKey(justX));
        assertTrue("The map should contain this key", groupby.containsKey(xy));
        assertEquals("noVars key in the map has an incorrect number of values", 2, groupby.get(noVars).size());
        assertEquals("justX key in the map has an incorrect number of values", 1, groupby.get(justX).size());
        assertEquals("xy key in the map has an incorrect number of values", 2, groupby.get(xy).size());
        assertTrue("The value of this key should contain this node", groupby.get(noVars).contains(two));
        assertTrue("The value of this key should contain this node", groupby.get(justX).contains(twoX));
        assertFalse("The value of this key should not contain this node", groupby.get(xy).contains(twoX));
    }
}
