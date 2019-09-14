// Generated from org/abcd/examples/ArrayInit/Express.g4 by ANTLR 4.7.2
package org.abcd.examples.ArrayInit;

import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * This class provides an empty implementation of {@link ExpressListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class MyExpressBaseListener extends ExpressBaseListener {
    @Override
    public void visitTerminal(TerminalNode node) {
        if (node.getSymbol().getType() == ExpressParser.ID) {
            System.out.println(node);
        }

    }

}