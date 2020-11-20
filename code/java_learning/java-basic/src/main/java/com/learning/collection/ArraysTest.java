package com.learning.collection;

import java.util.Arrays;

public class ArraysTest {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = new int[a.length << 1];
        System.out.println("a.length:" + a.length);
        System.out.println("b.length:" + b.length);
        b = Arrays.copyOf(a, b.length);
        for (int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
        System.out.println(b.length);

    }
}
