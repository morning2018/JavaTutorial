package com.learning.designpattern.creational.builder;

/**
 *  抽象建造商
 * @author morning
 * @date 2020/9/22 21:42
 * @since 0.0.1
 */
public abstract class ComputerBuilder {
    protected Computer computer = new Computer();

    public abstract void buildCpu();
    public abstract void buildMemory();
    public abstract void buildMainBorad();
    public abstract void buildHardDisk();

    /**
     *  生成的computer
     * @author morning
     * @date 2020/9/22 21:46
     * @since 0.0.1
     */
    public Computer getComputer() {
        return computer;
    }

}
