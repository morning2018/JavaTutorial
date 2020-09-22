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
public class SingletonTest {

    /**
     * 测试线程类，多线程获取单例的实例
     */
    private static class MyThread extends Thread {
        @Override
        public void run() {
            //printSingleton();
            printLazySingleton();
        }

        /**打印单例*/
        private void printSingleton() {
            System.out.println("线程："+ Thread.currentThread().getName() + "获取单例：" +
                    Singleton.getInstance().hashCode());
        }
        /**打印非安全懒汉单例*/
        private void printLazySingleton() {
            System.out.println("线程："+ Thread.currentThread().getName() + "获取单例：" +
                    LazySingleton.getInstance().hashCode());
            /**
             * 线程：t5获取单例：1058874213
             * 线程：t0获取单例：67641385
             * 线程：t7获取单例：1058874213
             * 线程：t9获取单例：1058874213
             * 线程：t3获取单例：1058874213
             * 线程：t1获取单例：1058874213
             * 线程：t6获取单例：1058874213
             * 线程：t8获取单例：1058874213
             * 线程：t2获取单例：1058874213
             * 线程：t4获取单例：1058874213
             * t0获取的实例与其他的实例不是同一个，存在线程安全问题
             */
        }
    }

    /**
     *  main函数
     * @param args
     */
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        for (int i = 0; i < 10 ; i++ ) {
            new Thread(myThread, "t"+i).start();
        }
    }
}
