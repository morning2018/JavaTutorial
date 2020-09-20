package com.learning.designpattern.prototype;

/**
 *  具体的原型类
 * @author morning
 * @date 2020/9/20 21:25
 * @since 0.0.1
 */
public class Realizetype implements Cloneable {

    public Realizetype() {
        System.out.println("具体原型创建成功");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        System.out.println("具体原型创建成功。");
        return (Realizetype)super.clone();
    }
}
