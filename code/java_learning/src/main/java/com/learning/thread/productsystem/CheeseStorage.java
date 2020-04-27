package com.learning.thread.productsystem;

/**
 * 功能描述：
 *  奶酪冷库
 * @author yt.wei
 * @date 2020/4/25 18:30
 * @version v0.0.1
 */
public class CheeseStorage {
    /**
     * 奶酪
     */
    private  int  cheese;

    public synchronized void add(){
        cheese ++;
    }
    public synchronized void reduce(int num){
        cheese = cheese - num;
    }
    public int getCheeseNum() {
        return cheese;
    }
}
