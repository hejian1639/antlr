package org.abcd.examples.ArrayInit; /***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
 ***/
// import ANTLR's runtime libraries

import lombok.val;
import org.abcd.examples.JudgeExpressLexer;
import org.abcd.examples.JudgeExpressParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class JudgeExpressTest {
    public static void main(String[] args) {
        // create a CharStream that reads from standard input
        ANTLRInputStream input = new ANTLRInputStream("(http_failed_count >= 3) && (http_success_count == 0 || http_success_count == null)");

        // create a lexer that feeds off of input CharStream
        JudgeExpressLexer lexer = new JudgeExpressLexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        JudgeExpressParser parser = new JudgeExpressParser(tokens);

        ParseTree tree = parser.judge(); // begin parsing at init rule
        System.out.println(tree.toStringTree(parser)); // print LISP-style tree
        ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
        MyJudgeExpressListener listener = new MyJudgeExpressListener(tokens);
        walker.walk(listener, tree); // initiate walk of tree with listener
        System.out.println(listener.rewriter.getText());
    }
}
