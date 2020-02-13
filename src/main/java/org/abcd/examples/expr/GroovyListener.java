package org.abcd.examples.expr; /***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
 ***/

import org.abcd.examples.GroovyParser;
import org.abcd.examples.GroovyParserBaseListener;
import org.abcd.examples.JavaBaseListener;
import org.abcd.examples.JavaParser;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;

public class GroovyListener extends GroovyParserBaseListener {
    TokenStreamRewriter rewriter;

    public GroovyListener(TokenStream tokens) {
        rewriter = new TokenStreamRewriter(tokens);
    }


}
