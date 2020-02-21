package com.dynamic.bill4j.link.foreignclassictextbook;

import com.sun.istack.internal.NotNull;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/2/21
 */
public class LinkList {
    private Link first;

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }
    public void insertFirst(@NotNull Link link) {
        link.next = first;
        first = link;
    }

    public Link removeFirst() {
        if (isEmpty()) {
            return first;
        }
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
