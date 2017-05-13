package ca.wolfram.beta.symath;

import java.util.List;

/**
 * Created by Allan Wang on 2017-05-06.
 * <p>
 * {@link #argCount}
 * key for number of arguments
 * exactly x if x >= 0
 * at least |x| if x < 0
 */
public enum NodeType {

    CONSTANT(0), MATH_CONSTANT(0), VARIABLE(0),
    ADD(-2), NEGATE(1), MULTIPLY(-2), POWER(2);

    public final int argCount;

    NodeType(int argCount) {
        this.argCount = argCount;
    }

    public void validateListSize(List<MathNode> list) {
        validateListSize(argCount, list, getCountException());
    }

    public static void validateListSize(int count, List<MathNode> list, String exception) {
        if ((count >= 0 && list.size() != count) || (count < 0 && list.size() < -count))
            throw new IllegalArgumentException(exception);
    }

    public String getCountException() {
        if (argCount == 0) return String.format("%s does not take any nodes", getName());
        if (argCount < 0)
            return String.format("%s needs at least %d %s", getName(), -argCount, argCount == -1 ? "node" : "nodes");
        return String.format("%s only takes %d %s", getName(), argCount, argCount == 1 ? "node" : "nodes");
    }

    public String getName() {
        String[] words = toString().split("_");
        StringBuilder name = new StringBuilder();
        for (String word : words)
            name.append(word.charAt(0)).append(word.substring(1).toLowerCase());
        return name.append("Node").toString();
    }
}
