package com.learning.designpattern.creational.builder;

/**
 *  指挥者
 * @author morning
 * @date 2020/9/22 21:50
 * @since 0.0.1
 */
public class ComputerBuilderDirector {
    private ComputerBuilder computerBuilder;
    public ComputerBuilderDirector(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }
    /**
     *  组装
     * @author morning
     * @date 2020/9/22 21:52
     * @since 0.0.1
     */
    public Computer construct() {
        computerBuilder.buildCpu();
        computerBuilder.buildMemory();
        computerBuilder.buildMainBorad();
        computerBuilder.buildHardDisk();
        return computerBuilder.getComputer();
    }
}
