package com.learning.jvm;

import java.util.Scanner;

/**
 *  jvm param test
 *  Examples： -XX:+PrintGCDetails -Xmx20M -Xms20M -Xmn10M
 *  Descriptions：
 *  -XX:+PrintGCDetails 打印gc信息
* @author morning
 * @date 2020/12/7 15:59
 * @since 0.0.1
 */
public class JvmParamTest {
    /**
     * 定义1M大小
     */
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int a = scanner.nextInt();
            byte[] bytes1 = new byte[ a * _1MB];
            if (a > 3) {
                //
                System.gc();
            }
        }
    }
}
