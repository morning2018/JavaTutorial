package com.learning.jvm;

/**
 * Eden区验证：
 * 对象优先在Eden区分配
 *
 *  -Xmx20M 最大Heap内存
 *  -Xms20M 初始Heap内存
 *  -Xmn10M 新生代大小(eden:from:to默认是8:1:1)
 *  -XX:+PrintGCDetails 打印GC信息
 * @author morning
 * @date 2020/4/15 21:40
 * @version v0.0.1
 */
public class EdenAlloTest {
    // 定义1M大小
    private static final int _1MB = 1024 * 1024;

    public static  void main(String[] args) {
        byte[] byte1, byte2, byte3,byte4;
        //初始化1M大小在Eden区
        byte1 = new byte[1*_1MB];
        byte2 = new byte[1*_1MB];
        // 大对象直接进入老年代，年轻代放不下的放入老年代
        byte3 = new byte[5*_1MB];
        //byte4 = new byte[2*_1MB];
        //byte4 = new byte[2*_1MB];
        //byte4 = new byte[2*_1MB];
        System.out.println("112");
    }
}
