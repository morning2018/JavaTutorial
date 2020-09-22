package com.learning.designpattern.creational.singleton;

/**
 * 懒汉单例模式特点：
 * 1. 为防止实例被多个构建，收敛实例化方式，将构造方法限制为private
 * 2. 建一个静态变量，持有自己的一个实例
 * 3. 通过静态方法对外提供这个实例
 *
 * @author morning
 * @date 2020/6/22 10:14
 * @see 0.0.1
 * @version v0.0.1
 */
public class LazySingleton {
    /** 持有的自己的静态实例*/
    private volatile static LazySingleton instance = null;

    /**私有化构造函数*/
    private LazySingleton() {
    }

    /**静态方法对外提供实例*/
    public static LazySingleton getInstance() {

        if (null == instance) {
            try {
                // 模拟处理逻辑
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new LazySingleton();
        }
        return instance;
    }

}
