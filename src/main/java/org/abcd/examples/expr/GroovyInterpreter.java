package org.abcd.examples.expr; /***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
 ***/

import lombok.val;
import org.abcd.examples.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.InputStream;

public class GroovyInterpreter {
    public static void main(String[] args) throws Exception {
        String inputFile = "app-alert.groovy";
        if (args.length > 0) inputFile = args[0];
        InputStream is = System.in;
        if (inputFile != null) is = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(is);
        GroovyLexer lexer = new GroovyLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GroovyParser parser = new GroovyParser(tokens);
        ParseTree tree = parser.compilationUnit(); // parse
        System.out.println(tree.toStringTree(parser)); // print LISP-style tree

        TokenStreamRewriter rewriter = new TokenStreamRewriter(tokens);
        ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
        walker.walk(new GroovyParserBaseListener(), tree); // initiate walk of tree with listener

        // print back ALTERED stream
        System.out.println(rewriter.getText());

    }
}
