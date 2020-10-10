package com.learning.designpattern.behavioral.interpreter;

/**
 *  non-terminal expression role
 * @author morning
 * @date 2020/10/6 21:45
 * @since 0.0.1
 */
public class NonterminalExpression  implements AbstractExpression{
    /**
     * interpret
     *
     * @param info :info
     * @return Object
     * @author morning
     * @date 2020/10/6 21:47
     * @since 0.0.1
     */
    @Override
    public Object interpret(String info) {
        System.out.println("non-interpret terminal expression");
        return "non-interpret terminal expression";
    }
}
