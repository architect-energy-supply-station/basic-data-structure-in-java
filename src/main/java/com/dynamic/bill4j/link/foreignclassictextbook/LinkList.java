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

    public Link indexOf(int id) {

        //    入参校验检查,应遵循业务规则，符合安全要求
        Link current = first;
        boolean found = false;
        if (current == null) {
            System.out.println("当前链表为空！");
            return first;
        }
        while (current != null) {
            if (current.iData == id) {
                found = true;
                break;
            }
            current = current.next;
        }
        if (found) {
            return current;
        } else {
            System.out.println("没有找到该节点");
            return null;
        }
    }

    //    删除算法，先查找到位置，进行标记，将当前节点内容缓存下来，删除操作的几个动作，依次执行
//    删除指定值的算法，找到位置，进行标记
    public Link remove(int id) {
        Link current = first;
        if (current == null) {
            return null;
        }
        boolean remove = false;
        Link previous = first;
        while (current != null) {
            if (current.iData==id) {
                remove = true;
                break;
            }
            previous = current;
            current = current.next;
        }
        if (remove) {
            Link result = current;
            if (previous == current) {
                first = first.next;
            } else {
                previous.next = current.next;
            }
            return result;
        } else {
            System.out.println("没有找到要删除的元素");
            return null;
        }
    }

    public Link remove3(int id) {
        if (first == null) {
            System.out.println("链表为空");
            return null;
        }
        Link current = first;
        Link previous = first;
        while (current.iData != id) {
            if (current.next == null) {
                //遍历结束没有找到
                System.out.println("遍历结束没有找到,该关键字对应的节点");
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }
        //特殊情况，要删除的当前节点，是第一个节点，很特殊，因为是由first域直接指向的节点，要删除的话，必须是first=first.next
        if (previous == current) {
            first = first.next;
        } else {
            previous.next = current.next;
            //两句话的意义一样
            // previous.next = previous.next.next;
        }
        return current;
    }
    @Deprecated
    public Link remove2(int id) {
        Link previous = first;
        if (first == null) {
            System.out.println("空链表");
            return null;
        }
        boolean delete = false;
        while (previous.next != null) {
            if (previous.next.iData == id) {
                delete = true;
                break;
            }
            previous = previous.next;
        }
        if (delete) {
            Link result = previous.next;
            //为什么这里的引用赋值和之前SingleLinkedList的set变量的情况不一样？和视频里面讲到的删除也不一样？为啥这种写法无法删第一个节点？
            //因为在进行添加的时候，这里的头结点，是不存在的。first直接是指向的第一个节点。所以第一个节点无法删除，很特殊 ，除非你有一个引用保存着前一个节点访问位置。而视频中之所以能够做到，是因为视频中的head节点，不动。而书上讲的示例，是不带头结点的操作方式。first是直接指向第一个节点的引用。-bill -2020-2-22
//fixme:[bill] please fix the bug here and make sure it works --Bill-liu 2020/2/22 23:17
        previous.next = previous.next.next;
            return result;
        } else {
            System.out.println("没有找到要删除的节点");
            return null;
        }
    }
}
