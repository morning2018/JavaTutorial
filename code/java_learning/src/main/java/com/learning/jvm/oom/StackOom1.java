package com.learning.jvm.oom;
/**
 * 循环调用方法，栈溢出，出现OOM:
 * Exception in thread "main" java.lang.StackOverflowError
 *
 * 说明：默认栈大小为：-Xss1M
 * @author morning
 * @date 2020/6/30 22:34
 * @version v0.0.1
 */
public class StackOom1 {

    protected void stackSOE(){
        stackSOE();
    }
    public static void main(String[] args) {
        StackOom1 stackSOE = new StackOom1();
        stackSOE.stackSOE();
    }
}
