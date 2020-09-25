package com.learning.designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 *  composite component role
 * @author morning
 * @date 2020/9/25 21:37
 * @since 0.0.1
 */
public class Composite implements Component {
    private List<Component> children = new ArrayList<Component>();

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    public Component getChild(int i) {
        return children.get(i);
    }

    public void operation() {
        for (Component obj : children) {
            obj.operation();
        }
    }
}
