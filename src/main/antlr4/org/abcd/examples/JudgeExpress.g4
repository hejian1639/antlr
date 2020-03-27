/** Grammars always start with a grammar header. This grammar is called
 *  ArrayInit and must match the filename: ArrayInit.g4
 */
grammar JudgeExpress;


/** A rule called init that matches comma-separated values between {...}. */


judge   :   variable '==' variable  #equal
        |   variable '!=' variable  #unequal
        |   variable '<' variable   #less
        |   variable '>' variable   #bigger
        |   variable '>=' variable  #biggerEqual
        |   judge '&&' judge        #and
        |   judge '||' judge        #or
        |   variable                #judgeVar
        |   '(' judge ')'           #bracket
        ;

variable    :   ID
            |   INT
            ;

// parser rules start with lowercase letters, lexer rules with uppercase
INT : [0-9]+ ;             // Define token INT as one or more digits
ID : [a-z_]+ ;
STRING : '\''[a-zA-Z.0-9]+'\'' ;
WS  :    [ \t\r\n]+ -> skip ; // Define whitespace rule, toss it out
