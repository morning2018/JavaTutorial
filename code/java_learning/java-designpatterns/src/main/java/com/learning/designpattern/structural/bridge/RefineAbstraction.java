package com.learning.designpattern.structural.bridge;

/**
 *  refine Abstraction role
 * @author morning
 * @date 2020/9/24 21:19
 * @since 0.0.1
 */
public class RefineAbstraction extends Abstraction {
    protected RefineAbstraction(Implementor implementor) {
        super(implementor);
    }

    /**
     *  operation implement
     * @author morning
     * @date 2020/9/24 21:20
     * @since 0.0.1
     */
    @Override
    public void operation() {
        System.out.println("refine abstraction role is called.");
        implementor.operationImpl();
    }
}
