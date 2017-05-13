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
        return eval == (long) eval;
    }

    public static boolean isConstantInt(MathNode node, long value) {
        return isConstantInt(node) && node.eval(null) == value;
    }

    public static boolean isZero(MathNode node) {
        return isConstantInt(node, 0);
    }

    public static boolean isOne(MathNode node) {
        return isConstantInt(node, 1);
    }

    public static boolean isNegativeConstant(MathNode node) {
        return node.isConstant() && (node.eval(null) < 0);
    }

    public static boolean isReciprocal(MathNode node) {
        return node.getType() == NodeType.POWER && isConstantInt(node.getChildren().get(1), -1L);
    }

    public static void print(String s, Object... o) {
        System.out.println(String.format(Locale.CANADA, s, o));
    }

}
