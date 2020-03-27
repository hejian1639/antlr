// Generated from org/abcd/examples/ArrayInit/Express.g4 by ANTLR 4.7.2
package org.abcd.examples.ArrayInit;

import org.abcd.examples.GroovyParser;
import org.abcd.examples.JudgeExpressBaseListener;
import org.abcd.examples.JudgeExpressParser;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.misc.Interval;

public class MyJudgeExpressListener extends JudgeExpressBaseListener {
    TokenStreamRewriter rewriter;

    public MyJudgeExpressListener(TokenStream tokens) {
        rewriter = new TokenStreamRewriter(tokens);
    }

    @Override
    public void exitEqual(JudgeExpressParser.EqualContext ctx) {
        String v0 = ctx.variable(0).getText();
        String v1 = ctx.variable(1).getText();
        rewriter.replace(ctx.start, ctx.stop, "equal(" + v0 + "," + v1 + ")");
    }

    @Override
    public void exitOr(JudgeExpressParser.OrContext ctx) {
        JudgeExpressParser.JudgeContext judge0 = ctx.judge(0);
        JudgeExpressParser.JudgeContext judge1 = ctx.judge(1);
        String v0 = rewriter.getText(Interval.of(judge0.start.getTokenIndex(), judge0.stop.getTokenIndex()));
        String v1 = rewriter.getText(Interval.of(judge1.start.getTokenIndex(), judge1.stop.getTokenIndex()));
        rewriter.replace(ctx.start, ctx.stop, "or(" + v0 + "," + v1 + ")");
    }

    @Override
    public void exitBiggerEqual(JudgeExpressParser.BiggerEqualContext ctx) {
        String v0 = ctx.variable(0).getText();
        String v1 = ctx.variable(1).getText();
        rewriter.replace(ctx.start, ctx.stop, "createEqualThan(" + v0 + "," + v1 + ")");
    }

    @Override
    public void exitAnd(JudgeExpressParser.AndContext ctx) {
        JudgeExpressParser.JudgeContext judge0 = ctx.judge(0);
        JudgeExpressParser.JudgeContext judge1 = ctx.judge(1);
        String v0 = rewriter.getText(Interval.of(judge0.start.getTokenIndex(), judge0.stop.getTokenIndex()));
        String v1 = rewriter.getText(Interval.of(judge1.start.getTokenIndex(), judge1.stop.getTokenIndex()));
        rewriter.replace(ctx.start, ctx.stop, "and(" + v0 + "," + v1 + ")");
    }

}