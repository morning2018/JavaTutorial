package com.learning.designpattern.behavioral.visitor;

/**
 *  concrete visitor A
 * @author morning
 * @date 2020/10/6 21:14
 * @since 0.0.1
 */
public class ConcreteVisitorA implements Visitor {
    /**
     * visit
     *
     * @param element : element A
     * @author morning
     * @date 2020/10/6 21:13
     * @since 0.0.1
     */
    @Override
    public void visit(ConcreteElementA element) {
        System.out.println("concrete visitor A visit :" + element.operationA());
    }

    /**
     * visit
     *
     * @param element : element B
     * @return
     * @author morning
     * @date 2020/10/6 21:14
     * @since 0.0.1
     */
    @Override
    public void visit(ConcreteElementB element) {
        System.out.println("concrete visitor A visit:" + element.operationB());
    }
}
