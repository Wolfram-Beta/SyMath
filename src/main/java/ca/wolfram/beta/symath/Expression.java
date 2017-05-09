package ca.wolfram.beta.symath;

/**
 * Created by Allan Wang on 2017-05-08.
 * <p>
 * Holds the root of a Math tree, as well as a value variableMap of the variables & math constants
 */
public class Expression {

    private final VMap variableMap = new VMap();
    private final static VMap constantMap = new VMap();
    private MathNode root;

    public VMap getVariableMap() {
        return variableMap;
    }

    public static VMap getConstantMap() {
        return constantMap;
    }

}
