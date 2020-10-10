package com.learning.multithread.practice.productsystem;

/**
 * 功能描述：
 *  发酵剂存储
 * @author yt.wei
 * @date 2020/4/25 18:31
 * @version v0.0.1
 */
public class FermentationStorage {
    /**
     * 发酵剂
     */
    private int fermentation;

    public synchronized void add(){
        fermentation ++;
    }
    public synchronized void reduce(int num){
        fermentation = fermentation - num;
    }
    public int getFermentationNum() {
        return fermentation;
    }
}
