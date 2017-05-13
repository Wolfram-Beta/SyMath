package parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.wolfram.beta.symath.MathNode;
import ca.wolfram.beta.symath.VMap;
import ca.wolfram.beta.symath.parser.ParserWrapper;

public class ParserTester {

    public final VMap variableMap = new VMap();

    @Test
    public void expression(){
        String strExp = "-x + x * 3.5^(x+1) / 3.5E-12 + (x-1) / (pi + 2)";
        MathNode a = ParserWrapper.stringToExpression(strExp);
        variableMap.put("x", 1.0);
        assertEquals("The eval function should equal", 3.5E12, a.eval(variableMap), 10);
    }

    @Test
    public void scientificNotation() {
        String strExp = "3E2";
        MathNode a = ParserWrapper.stringToExpression(strExp);
        variableMap.put("x", 1.0);
        assertEquals("The eval function should equal", 3E2, a.eval(variableMap), 0.01);
    }

    @Test
    public void Decimal() {
        String strExp = "3.2";
        MathNode a = ParserWrapper.stringToExpression(strExp);
        variableMap.put("x", 1.0);
        assertEquals("The eval function should equal", 3.2, a.eval(variableMap), 0.01);
    }

    @Test
    public void wholeNumber() {
        String strExp = "-3";
        MathNode a = ParserWrapper.stringToExpression(strExp);
        variableMap.put("x", 1.0);
        assertEquals("The eval function should equal", -3, a.eval(variableMap), 0.01);
    }

    @Test
    public void complexScientificaNotation() {
        String strExp = "-3.12E-12";
        MathNode a = ParserWrapper.stringToExpression(strExp);
        variableMap.put("x", 1.0);
        assertEquals("The eval function should equal", -3.12E-12, a.eval(variableMap), 0.01);
    }

    @Test
    public void variable() {
        String strExp = "x";
        MathNode a = ParserWrapper.stringToExpression(strExp);
        variableMap.put("x", 1.0);
        assertEquals("The eval function should equal", 1.0, a.eval(variableMap), 0.01);
    }

    @Test
    public void simpleTerm() {
        String strExp = "2.1*x";
        MathNode a = ParserWrapper.stringToExpression(strExp);
        variableMap.put("x", 1.0);
        assertEquals("The eval function should equal", 2.1, a.eval(variableMap), 0.01);
    }

    @Test
    public void complexTerm() {
        String strExp = "x * 3.5^(x+1) / 3.5E-12";
        MathNode a = ParserWrapper.stringToExpression(strExp);
        variableMap.put("x", 1.0);
        assertEquals("The eval function should equal", 3.5E12, a.eval(variableMap), 0.1);
    }

}


