package com.learning.designpattern.structural.composite;

/**
 *  leaf component role
 * @author morning
 * @date 2020/9/25 21:35
 * @since 0.0.1
 */
public class Leaf implements Component {
    private String name;
    public Leaf(String name) {
        this.name = name;
    }
    public void add(Component component) {
    }

    public void remove(Component component) {
    }

    public Component getChild(int i) {
        return null;
    }

    public void operation() {
        System.out.println("leaf "+ name + " is visited.");
    }
}
