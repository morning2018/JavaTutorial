package com.learning.datastructure.linkedlist;

import lombok.Data;

/**
 * 功能描述：
 *  单向链表节点
 * @author morning
 * @date 2020/4/20 17:04
 * @version v0.0.1
 */
@Data
public class Node<T> {
    /**
     * 数据
     */
    private T data;

    /**
     * 下一个节点
     */
    private Node next;

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }
    public Node(T data) {
       this(data, null);
    }
}
