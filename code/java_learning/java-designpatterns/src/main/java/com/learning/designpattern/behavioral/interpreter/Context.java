package com.learning.designpattern.behavioral.interpreter;

/**
 *  context role
 * @author morning
 * @date 2020/10/6 21:46
 * @since 0.0.1
 */
public class Context {
    private AbstractExpression expression;
    public Context() {
        System.out.println("init data");
    }
    public void operation(String info) {

        expression.interpret(info);
    }
}
