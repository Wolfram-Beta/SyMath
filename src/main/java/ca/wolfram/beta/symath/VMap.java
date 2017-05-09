package ca.wolfram.beta.symath;
import java.util.HashMap;

/**
 * Our own hashmap implementation to warn users when overwriting values
 */
public class VMap extends HashMap<String, Double> {
    @Override
    public Double put(String key, Double value) {
        if (containsKey(key))
            System.out.println(String.format("Caution: %s was already added with a value of %f", key, get(key)));
        return super.put(key, value);
    }

    public double get(String key, double fallback) {
        if (containsKey(key)) return get(key);
        return fallback;
    }

    public double get(String key, String errorMessage) {
        if (containsKey(key)) return get(key);
        throw new IllegalArgumentException(errorMessage);
    }
}
