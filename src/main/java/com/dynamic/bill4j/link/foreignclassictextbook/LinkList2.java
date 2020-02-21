package com.dynamic.bill4j.link.foreignclassictextbook;

import com.sun.istack.internal.NotNull;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/2/21
 */
public class LinkList2 {
    //用来存放头结点，用来指向第一个节点
    private Link2 first;

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 每次都从头结点插入
     * @param id
     * @param dd
     */
    public void insertFirst(int id, double dd) {
        Link2 newLink2 = new Link2(id, dd);
        newLink2.next = first;
        first = newLink2;
    }

    public void insertFirst(@NotNull Link2 link) {
        link.next = first;
        first = link;
    }

    public Link2 removeFirst() {
        if (isEmpty()) {
            return first;
        }
        Link2 temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        Link2 current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
