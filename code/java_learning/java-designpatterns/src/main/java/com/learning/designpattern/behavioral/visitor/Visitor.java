package com.learning.designpattern.behavioral.visitor;

/**
 *  abstract visitor role
 * @author morning
 * @date 2020/10/6 20:50
 * @since 0.0.1
 */
public interface Visitor {
    /**
     * visit
     * @author morning
     * @date 2020/10/6 21:13
     * @since 0.0.1
     * @param element: element A
     */
    void visit(ConcreteElementA element);
    
    /**
     * visit
     * @author morning
     * @date 2020/10/6 21:14
     * @since 0.0.1
     * @param element : element B
     * @return  
     */
    void visit(ConcreteElementB element);
}
