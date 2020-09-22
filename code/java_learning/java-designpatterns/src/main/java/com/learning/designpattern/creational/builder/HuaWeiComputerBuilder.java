package com.learning.designpattern.creational.builder;

/**
 *  具体的建造者
 * @author morning
 * @date 2020/9/22 21:49
 * @since 0.0.1
 */
public class HuaWeiComputerBuilder extends ComputerBuilder {
    @Override
    public void buildCpu() {
      computer.setCpu("huawei cpu");
    }

    @Override
    public void buildMemory() {
        computer.setMemory("huawei memory");
    }

    @Override
    public void buildMainBorad() {
        computer.setMainBoard("huawei main board");
    }

    @Override
    public void buildHardDisk() {
        computer.setHardDisk("huawei hard disk");
    }
}
