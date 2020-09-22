package com.learning.designpattern.creational.singleton;

/**
 * 单例模式特点：
 * 1. 为防止实例被多个构建，收敛实例化方式，将构造方法限制为private
 * 2. 建一个静态变量，持有自己的一个实例
 * 3. 通过静态方法对外提供这个实例
 *
 * @author morning
 * @date 2020/6/22 10:14
 * @see 0.0.1
 * @version v0.0.1
 */
public class Singleton {
    /** 持有的自己的静态实例,懒汉模式*/
    private volatile static Singleton instance = null;

    /**私有化构造函数*/
    private Singleton() {
    }

    /**静态方法对外提供实例*/
    public static Singleton getInstance() {
        if (null == instance) {
            synchronized (Singleton.class) {
                if (null == instance) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
