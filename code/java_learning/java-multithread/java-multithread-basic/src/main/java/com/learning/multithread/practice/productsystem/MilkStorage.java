package com.learning.multithread.practice.productsystem;

/**
 * 功能描述：
 *  牛奶生产线
 * @author yt.wei
 * @date 2020/4/25 8:33
 * @version v0.0.1
 */

public class MilkStorage {
    /**
     * 牛奶
     */
    private int milk;

    public synchronized void add(){
        milk ++;
    }
    public synchronized void reduce(int num){
        milk = milk - num;
    }
    public int getMilkNum() {
        return milk;
    }
}
