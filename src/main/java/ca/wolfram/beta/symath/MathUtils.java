package ca.wolfram.beta.symath;

import java.util.Locale;

/**
 * Created by Allan Wang on 2017-05-09.
 * <p>
 * Collection of helper methods
 */
public class MathUtils {

    public static boolean isConstantInt(MathNode node) {
        if (!node.isConstant()) return false;
        double eval = node.eval(null);
        return eval == (int) eval;
    }

    public static void print(String s, Object... o) {
        System.out.println(String.format(Locale.CANADA, s, o));
    }

}
