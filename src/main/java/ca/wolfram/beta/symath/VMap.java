package ca.wolfram.beta.symath;

import java.util.HashMap;

/**
 * Our own hashmap implementation to warn users when overwriting values
 */
public class VMap extends HashMap<String, Double> {

    /**
     * Put method that will warn if key is already added
     *
     * @param key            to add
     * @param value          to set
     * @param throwException true to throw error, false to warn
     * @return result of put
     */
    public Double put(String key, Double value, boolean throwException) {
        if (containsKey(key) && !super.get(key).equals(value))
            if (throwException)
                throw new IllegalArgumentException(String.format("Error: %s was already added with a value of %f", key, super.get(key)));
            else
                MathUtils.print("Caution: %s was already added with a value of %f", key, super.get(key));
        return super.put(key, value);
    }

    public double get(String key, double fallback) {
        if (containsKey(key)) return super.get(key);
        return fallback;
    }

    public double get(String key, String errorMessage) {
        if (containsKey(key)) return super.get(key);
        throw new IllegalArgumentException(errorMessage);
    }
}
