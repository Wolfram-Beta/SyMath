grammar Expr;

prog
   : (expression NEWLINE)*
   ;

equation // Unused for now too
   : expression relop expression
   ;

expression
   : term ((PLUS | MINUS) term)*
   ;

term
   : factor ((TIMES | DIV) factor)*
   ;

factor
   : atom (POW atom)*
   ;

atom
   : scientific
   | variable
   | LPAREN expression RPAREN
   ;

scientific
   : number (E number)?
   ;

relop
   : EQ
   | GT
   | LT
   | NEWLINE
   ;

number
   : MINUS? DIGIT + (POINT DIGIT +)?
   ;

variable
   : MINUS? LETTER (LETTER | DIGIT)*
   ;


LPAREN
   : '('
   ;


RPAREN
   : ')'
   ;


PLUS
   : '+'
   ;


MINUS
   : '-'
   ;


TIMES
   : '*'
   ;


DIV
   : '/'
   ;

// Unused below for now

GT
   : '>'
   ;


LT
   : '<'
   ;

EQ
   : '='
   ;

// Unused above for now

POINT
   : '.'
   ;


E
   : 'e' | 'E'
   ;


POW
   : '^'
   ;

NEWLINE 
   : [\r\n]+ 
   ;

LETTER
   : ('a' .. 'z') | ('A' .. 'Z')
   ;


DIGIT
   : ('0' .. '9')
   ;


WS
   : [ \r\n\t] + -> channel (HIDDEN)
   ;