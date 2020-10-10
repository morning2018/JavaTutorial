package com.learning.designpattern.behavioral.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *  object structure
 * @author morning
 * @date 2020/10/6 21:20
 * @since 0.0.1
 */
public class ObjectStructure {
    private List<Element> list = new ArrayList<>();
    public void accept(Visitor visitor) {
        Iterator<Element> iterator = list.iterator();
        while (iterator.hasNext()) {
           iterator.next().accept(visitor);
        }
    }
    public void add(Element element) {
        list.add(element);
    }
    public void remove(Element element) {
        list.remove(element);
    }
}
