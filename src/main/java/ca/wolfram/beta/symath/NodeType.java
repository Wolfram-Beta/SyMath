package ca.wolfram.beta.symath;

import java.util.List;

/**
 * Created by Allan Wang on 2017-05-06.
 * <p>
 * {@link #argCount} maximum number of arguments for type; -1 for inf
 */
public enum NodeType {

    CONSTANT(0), MATH_CONSTANT(0), VARIABLE(0),
    ADD(-1), NEGATE(1), MULTIPLY(-1), POWER(2);

    public final int argCount;

    NodeType(int argCount) {
        this.argCount = argCount;
    }

    public void validateListSize(List<MathNode> list){
        if (argCount != -1 && list.size() != argCount)
            throw new IllegalArgumentException(getCountException());
    }

    public String getCountException() {
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
