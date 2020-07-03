package com.learning.jvm.ch1;
/**
 * stack overflow error验证：
 * -Xss 1M
 * @author morning
 * @date 2020/6/30 22:34
 * @version v0.0.1
 */
public class StackSOE {
    protected void stackSOE(){
        stackSOE();
    }
    public static void main(String[] args) {
        StackSOE stackSOE = new StackSOE();
        stackSOE.stackSOE();
    }
}
