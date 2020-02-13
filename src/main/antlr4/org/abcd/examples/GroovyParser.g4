/** Grammars always start with a grammar header. This grammar is called
 *  ArrayInit and must match the filename: ArrayInit.g4
 */
parser grammar GroovyParser;

options { tokenVocab=GroovyLexer; }

/** A rule called init that matches comma-separated values between {...}. */


compilationUnit :  TEXT* eval TEXT* ;

eval    : EVAL_BEGIN EVAL_END ;


