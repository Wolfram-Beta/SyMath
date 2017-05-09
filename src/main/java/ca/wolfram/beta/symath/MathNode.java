package ca.wolfram.beta.symath;

import java.util.List;

public interface MathNode {

    // static MathNode create(ArrayList<MathNode> nodes);
    // static MathNode create(MathNode ... nodes);
    NodeType getType();

    /**
     * Retrieves the list of children from a given node
     * If the list will be modified, make sure to call {@link #simplify()} when appropriate
     *
     * @return list of MathNodes
     */
    List<MathNode> getChildren();

    /**
     * Returns true if node is a constant, false otherwise
     *
     * @return constant status
     */
    boolean isConstant();

    /**
     * Evaluates a given node and returns its result
     *
     * @param map VMap for variables; null for constants
     * @return result as a double
     */
    double eval(VMap map);

    /**
     * Simplifies node & its children
     *
     * @return true if result is a constant, false otherwise
     */
    boolean simplify();

    /**
     * Returns node contents as a string
     *
     * @return node contents
     */
    String toString();
}
