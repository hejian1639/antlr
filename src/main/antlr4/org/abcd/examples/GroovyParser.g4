/** Grammars always start with a grammar header. This grammar is called
 *  ArrayInit and must match the filename: ArrayInit.g4
 */
parser grammar GroovyParser;

options { tokenVocab=GroovyLexer; }

/** A rule called init that matches comma-separated values between {...}. */


compilationUnit:  TEXT* eval* TEXT* ;

eval: EVAL_BEGIN stat* EVAL_END ;


stat:   ID ASSIGN aggregation NEWLINE
    |   NEWLINE
    ;

expr:   expr MUL expr
    |   expr DIV expr
    |   expr ADD expr
    |   expr SUB expr
    |   NUMBER
    |   ID
    |   LEFT_BRACKET expr RIGHT_BRACKET
    ;

judge   :   expr EQUAL expr     #equal
        |   expr UNEQUAL expr   #unequal
        ;

aggregation :   ID DOT function
            |   function
            ;

function:   COUNT_IF LEFT_BRACKET judge RIGHT_BRACKET
        |   COUNT
        |   SUM LEFT_BRACKET expr RIGHT_BRACKET
        |   AVERAGE LEFT_BRACKET expr RIGHT_BRACKET
        ;