package ca.wolfram.beta.symath;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

    public static void print(String s, Object... o) {
        System.out.println(String.format(Locale.CANADA, s, o));
    }

    public static Set<MathNode> getVariableTerms(MathNode node) {
        Set<MathNode> set;
        switch (node.getType()) {
        case CONSTANT:
        case MATH_CONSTANT:
            set = new HashSet<MathNode>();
            break;
        case VARIABLE:
        case POWER:
            set = new HashSet<MathNode>();
            set.add(node);
            break;
        default:
            set = node.getChildren().stream().filter(children -> !children.isConstant()).collect(Collectors.toSet());
            break;
        }
        return set;
    }

    public static boolean isLikeTerm(MathNode n1, MathNode n2) {
        if (n1.getType() != NodeType.MULTIPLY || n2.getType() != NodeType.MULTIPLY) return false;
        return getVariableTerms(n1).equals(getVariableTerms(n2));
    }

    public static Map<Set<MathNode>, List<MathNode>> groupByLikeTerms(List<MathNode> nodes) {
        return nodes.stream().collect(Collectors.groupingBy(node -> getVariableTerms(node)));
    }

}
