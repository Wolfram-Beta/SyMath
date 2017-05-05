package ca.wolfram.beta.symath;

import java.util.HashMap;

/**
 * Created by Allan Wang on 2017-05-08.
 */
class VariableMap {

    private static VariableMap sInstance = new VariableMap();

    static VMap getMap() {
        return sInstance.map;
    }

    private final VMap map = new VMap();

    private VariableMap() {
    }

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
    }

}
