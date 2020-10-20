package com.learning.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
  *  client
  * @author weiyt
  * @date 2020/10/20 12:36
  * @since 3.1.0-SNAPSHOT
  */
public class HelloAnnotationClient {

    @HelloAnnotation("test hello")
    private String test;

    @HelloAnnotation("clientId hello")
    private Long clientId;

    @HelloAnnotation("test method hello")
    public void testMethod(Long clientId) {
        System.out.println("test method called");
    }

    public static void main(String[] args) {
        Class clazz = HelloAnnotationClient.class;
        try {
            Field f = clazz.getDeclaredField("test");
            HelloAnnotation hello = f.getAnnotation(HelloAnnotation.class);
            // test hello
            System.out.println(hello.value());

            f = clazz.getDeclaredField("clientId");
            hello = f.getAnnotation(HelloAnnotation.class);
            //clientId hello
            System.out.println(hello.value());

            Method method = clazz.getMethod("testMethod",Long.class);
            hello = method.getAnnotation(HelloAnnotation.class);
            // test method hello
            System.out.println(hello.value());

        } catch (NoSuchFieldException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
