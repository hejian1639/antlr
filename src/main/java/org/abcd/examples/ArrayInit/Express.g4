/** Grammars always start with a grammar header. This grammar is called
 *  ArrayInit and must match the filename: ArrayInit.g4
 */
grammar Express;

@header {
package org.abcd.examples.ArrayInit;
}

/** A rule called init that matches comma-separated values between {...}. */

express : and
        | condition
        ;

and : condition 'and' condition  ;
condition   : unequal
            | equal ;

unequal : ID '!=' STRING
        | ID '!=' INT
        ;
equal : ID '=' STRING
      | ID '=' INT
      ;

// parser rules start with lowercase letters, lexer rules with uppercase
INT : [0-9]+ ;             // Define token INT as one or more digits
ID : [a-z_]+ ;
STRING : '\''[a-zA-Z.0-9]+'\'' ;
WS  :    [ \t\r\n]+ -> skip ; // Define whitespace rule, toss it out
