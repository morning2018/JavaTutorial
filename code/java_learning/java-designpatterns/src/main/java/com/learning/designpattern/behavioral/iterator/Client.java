package com.learning.designpattern.behavioral.iterator;

/**
 *  client
 * @author morning
 * @date 2020/10/6 20:43
 * @since 0.0.1
 */
public class Client {
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("清华大学");
        aggregate.add("北京大学");
        aggregate.add("中国科技大学");
        aggregate.add("南京大学");
        System.out.println("aggregate content:");
        Iterator iterator = aggregate.getIterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            System.out.println(object.toString());
        }
        Object first = iterator.first();
        System.out.println("First:" + first.toString());
    }
}
