package ca.wolfram.beta.symath;

/**
 * Created by Allan Wang on 2017-05-06.
 * <p>
 * {@link #argCount} maximum number of arguments for type; -1 for inf
 */
public enum NodeType {

    CONSTANT(0), MATHCONSTANT(0), VARIABLE(0),
    ADD(-1), NEGATE(1), MULTIPLY(-1), POWER(2);

    public final int argCount;

    NodeType(int argCount) {
        this.argCount = argCount;
    }
}
