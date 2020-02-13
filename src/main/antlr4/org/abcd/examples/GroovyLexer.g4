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
IGNORE      :   .    -> more ;
//EVAL_TEXT    : (.)* ;                         // clump all text together

//// parser rules start with lowercase letters, lexer rules with uppercase
//INT     : [0-9]+ ;             // Define token INT as one or more digits
//ID      : JavaLetter JavaLetterOrDigit*;
//STRING  : '\''[a-zA-Z.0-9]+'\'' ;
//WS      :  [ \t\u000C\n]+     -> skip ;
//DOT     : '.';
//
//fragment
//JavaLetter
//    :   [a-zA-Z$_] // these are the "java letters" below 0x7F
//    ;
//fragment
//JavaLetterOrDigit
//    :   [a-zA-Z0-9$_] // these are the "java letters or digits" below 0x7F
//    ;
