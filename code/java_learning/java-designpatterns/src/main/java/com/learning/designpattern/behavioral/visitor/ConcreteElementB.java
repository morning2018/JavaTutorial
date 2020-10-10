package com.learning.designpattern.behavioral.visitor;

/**
 *  concrete element B
 * @author morning
 * @date 2020/10/6 21:10
 * @since 0.0.1
 */
public class ConcreteElementB implements Element  {
    /**
     * accept visitor
     *
     * @param visitor
     * @author morning
     * @date 2020/10/6 20:52
     * @since 0.0.1
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * operation B
     * @author morning
     * @date 2020/10/6 21:16
     * @since 0.0.1
     * @return  String
     */
    public String operationB(){
        return "the operation of concrete element B";
    }
}
