grammar Expression;

//  java -jar antlr-4.5.3-complete.jar -o src/main/java/ca/wolfram/beta/symath/parser/ src/main/java/ca/wolfram/beta/symath/parser/Expression.g4

prog : equation (NEWLINE equation)* ;
equation : expression (relop expression)* ;
expression : term ((PLUS | MINUS) term)* ;
term : factor ((TIMES | DIV) factor)* ;
factor : atom (POW atom)? ;
atom : scientific | variable | LPAREN expression RPAREN ;

scientific : decimal (E wholenumber)? ;
decimal : wholenumber POINT? digits* ;
wholenumber : MINUS? digits;
digits : DIGIT+ ;
variable : MINUS? LETTER + (LETTER | DIGIT)* ;
relop : EQ | GT | LT | NEWLINE ;


LETTER : ('a' .. 'z') ;
DIGIT : ('0' .. '9') ;

// Unused below for now

GT : '>' ;
LT : '<' ;
EQ : '=' ;

// Unused above for now

LPAREN : '(' ;
RPAREN : ')' ;
PLUS : '+' ;
MINUS : '-'  ;
TIMES : '*' ;
DIV : '/' ;
POINT : '.' ;
E : 'E' ;
POW : '^' ;
NEWLINE : [\r\n]+ ;

WS : [ \r\n\t] + -> channel (HIDDEN) ;