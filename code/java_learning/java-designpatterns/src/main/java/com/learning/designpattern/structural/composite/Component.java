package com.learning.designpattern.structural.composite;

/**
 *  abstract component
 * @author morning
 * @date 2020/9/25 21:31
 * @since 0.0.1
 */
public interface Component {
    /**
     *  add component
     * @author morning
     * @date 2020/9/25 21:33
     * @since 0.0.1
     * @param component
     */
    public void add(Component component);

    /**
     *  remove component
     * @author morning
     * @date 2020/9/25 21:33
     * @since 0.0.1
     * @param component
     */
    public void remove(Component component);

    /**
     *  get child component
     * @author morning
     * @date 2020/9/25 21:34
     * @since 0.0.1
     * @param i
     * @return
     */
    public Component getChild(int i);
    
    /**
     *  operation
     * @author morning
     * @date 2020/9/25 21:34
     * @since 0.0.1
     */
    public void operation();
    
}
