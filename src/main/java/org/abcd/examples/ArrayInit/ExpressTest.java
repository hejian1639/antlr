package org.abcd.examples.ArrayInit; /***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
***/
// import ANTLR's runtime libraries

import org.abcd.examples.ExpressLexer;
import org.abcd.examples.ExpressParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;

public class ExpressTest {
    public static void main(String[] args) throws Exception {
        // create a CharStream that reads from standard input
        ANTLRInputStream input = new ANTLRInputStream("rsp_delay_time>4*app_satisfied_time AND status_type IN (1, 2, 3)");

        // create a lexer that feeds off of input CharStream
        ExpressLexer lexer = new ExpressLexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        ExpressParser parser = new ExpressParser(tokens);

        ParseTree tree = parser.express(); // begin parsing at init rule
        System.out.println(tree.toStringTree(parser)); // print LISP-style tree
        ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
        walker.walk(new MyExpressBaseListener(), tree); // initiate walk of tree with listener
    }
}
