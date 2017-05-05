package ca.wolfram.beta.symath;

import java.util.List;

public interface MathNode {

    // static MathNode create(ArrayList<MathNode> nodes);
    // static MathNode create(MathNode ... nodes);
    NodeType getType();

    List<MathNode> getChildren();

    boolean isConstant();

    double eval();

    /**
     * Simplifies node & its children
     *
     * @return true if result is a constant
     */
    boolean simplify();

    String toString();
}
