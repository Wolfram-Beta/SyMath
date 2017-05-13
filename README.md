# SyMath

Solves expressions without precision loss.

[![Build Status](https://travis-ci.org/Wolfram-Beta/SyMath.svg?branch=master)](https://travis-ci.org/Wolfram-Beta/SyMath)

SyMath creates an expression tree, and simplifies as much as it can before inserting values. 
The expression tree is composed on OperationNode internals and BaseNode leaves.
All nodes adhere to the [MathNode](https://github.com/Wolfram-Beta/SyMath/blob/master/src/main/java/ca/wolfram/beta/symath/MathNode.java) interface.
Math constants and other variables are defined in advance using a VMap (HashMap<String, Double>) from the expression.