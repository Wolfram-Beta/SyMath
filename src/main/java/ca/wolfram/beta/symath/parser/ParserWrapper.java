package ca.wolfram.beta.symath.parser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import ca.wolfram.beta.symath.MathNode;

public class ParserWrapper {

    public static MathNode stringToExpression(String query){
        ANTLRInputStream input = new ANTLRInputStream(query);
        ExpressionLexer lexer = new ExpressionLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);
        ExpressionParser parser = new ExpressionParser(tokens);
        ParseTree tree = parser.prog();
        //System.out.println(tree.toStringTree(parser));

        ParseTreeWalker walker = new ParseTreeWalker();
        ExpressionListener listener = new AntlrExpressionListener();
        walker.walk(listener, tree);
        return ((AntlrExpressionListener) listener).getExpression() ;
    }
}
