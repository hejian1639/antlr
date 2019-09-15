/** Grammars always start with a grammar header. This grammar is called
 *  ArrayInit and must match the filename: ArrayInit.g4
 */
grammar Express;


/** A rule called init that matches comma-separated values between {...}. */


express : calculate
        | condition
        | and
        | or
        | express 'AND' condition
        | express 'OR' condition
        ;

and     : condition 'AND' condition ;

or      : condition 'OR' condition ;

condition   : unequal
            | equal
            | in
            | compare
            | between
            ;

unequal : ID '!=' STRING
        | ID '!=' INT
        | ID '!=' ID
        ;
equal   : ID '=' STRING
        | ID '=' INT
        | ID '=' ID
        ;

compare : calculate '>' variable
        | calculate '<' variable
        | calculate '>=' variable
        | calculate '<=' variable
        ;

variable    : ID
            | INT
            ;

calculate   : variable
            | variable '+' variable
            | variable '-' variable
            | variable '*' variable
            | variable '/' variable
            ;

in      : ID 'IN' '(' array ')' ;

array   : INT
        | array ',' INT
        ;

between  : ID 'BETWEEN' calculate 'AND' calculate ;


// parser rules start with lowercase letters, lexer rules with uppercase
INT : [0-9]+ ;             // Define token INT as one or more digits
ID : [a-z_]+ ;
STRING : '\''[a-zA-Z.0-9]+'\'' ;
WS  :    [ \t\r\n]+ -> skip ; // Define whitespace rule, toss it out
