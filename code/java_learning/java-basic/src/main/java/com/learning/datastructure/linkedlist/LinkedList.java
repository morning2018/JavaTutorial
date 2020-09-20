package com.learning.datastructure.linkedlist;

import lombok.Data;

/**
 * 功能描述：
 *  单向链表
 * @author morning
 * @date 2020/4/20 17:18
 * @version v0.0.1
 */
@Data
public class LinkedList<T> {
    // 头节点
    private Node head;
    // 节点数
    private int size;
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    // 链表第一个数据
    public void addFirst(T data) {
        Node node = new Node(data);
        node.setNext(this.head);
        this.head = node;
        this.size ++;
    }

    // 链表尾插入数据
    public void addLast(T data) {

    }
}
