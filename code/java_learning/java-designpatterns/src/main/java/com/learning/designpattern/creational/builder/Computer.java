package com.learning.designpattern.creational.builder;

/**
 *  复杂产品：由多个组件组成的复杂对象
 * @author morning
 * @date 2020/9/22 21:30
 * @since 0.0.1
 */
public class Computer {
    private String cpu;
    private String memory;
    private String mainBoard;
    private String hardDisk;
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }
    public void setMemory(String memory) {
        this.memory = memory;
    }
    public void setMainBoard(String mainBoard) {
        this.mainBoard = mainBoard;
    }
    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public void show() {
        System.out.println(this.cpu);
        System.out.println(this.memory);
        System.out.println(this.mainBoard);
        System.out.println(this.hardDisk);

    }
}
