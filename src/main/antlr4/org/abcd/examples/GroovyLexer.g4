/** Grammars always start with a grammar header. This grammar is called
 *  ArrayInit and must match the filename: ArrayInit.g4
 */
lexer grammar GroovyLexer;







EVAL_BEGIN  :   'eval' WS* '{'  ->  pushMode(EVAL_MODE) ;
TEXT    : . ;                         // clump all text together

fragment
WS      :  [ \t\n]+     -> skip ;



mode EVAL_MODE;

EVAL_END    :   '}'  -> popMode ;
//IGNORE      :   .    -> more ;

// parser rules start with lowercase letters, lexer rules with uppercase
STRING  :   '\''[a-zA-Z.0-9]+'\'' ;
NEWLINE :   '\r'? '\n' ;     // return newlines to parser (is end-statement signal)
EVAL_WS :   [ \t]+ -> skip ; // toss out whitespace
ASSIGN  :   '=' ; // toss out whitespace
MUL     :   '*' ; // assigns token name to '*' used above in grammar
DIV     :   '/' ;
ADD     :   '+' ;
SUB     :   '-' ;

LEFT_BRACKET    :   '(' ;
RIGHT_BRACKET   :   ')' ;

EQUAL   :   '==' ;
UNEQUAL :   '!=' ;
COUNT_IF:   'countIf' ;
COUNT   :   'count' ;
SUM     :   'sum' ;
AVERAGE :   'average' ;
ID      :   JavaLetter JavaLetterOrDigit*;
NUMBER  :   (DecimalLiteral|FloatingPointLiteral) ;             // Define token INT as one or more digits
DOT     :   '.';

DecimalLiteral : ('0' | '1'..'9' '0'..'9'*) ;
FloatingPointLiteral :   ('0'..'9')+ '.' ('0'..'9')* ;

fragment
JavaLetter
    :   [a-zA-Z$_] // these are the "java letters" below 0x7F
    ;
fragment
JavaLetterOrDigit
    :   [a-zA-Z0-9$_] // these are the "java letters or digits" below 0x7F
    ;
