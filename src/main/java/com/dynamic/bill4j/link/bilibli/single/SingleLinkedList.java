package com.dynamic.bill4j.link.bilibli.single;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/2/15
 */
public class SingleLinkedList {
    public HeroNode getHead() {
        return head;
    }

    private HeroNode head;
    private int count;

    public int getCount() {
        return count;
    }

    public SingleLinkedList() {
        this.head = new HeroNode(0, "", "");
        this.count = 0;
    }
    //不考虑链表序号的顺序
    //思路二：每次添加都往链表的头部进行插入
    //思路三：每次添加都往链表的任意位置进行插入

    //思路一：每次添加都往链表的最后进行插入
    public void add(HeroNode heroNode) {
    //    想找到链表的最后：遍历链表，直到next的值为null，进行插入（将最后节点next的值指向新的node）
    //     加入辅助变量
        HeroNode temp = head;
        while (true) {
            if (temp.getNextNode() == null) {
                break;
            }
            temp = temp.getNextNode();
        }
         //next 节点指向新的Node
         temp.setNextNode(heroNode);
        count++;
    }

    //考虑链表的有序性，每次插入保证链表是有序的


    public void display() {
        if (isEmpty()) {
            System.out.println("链表为空!");
            throw new LinkedListEmptyException("链表为空!");
        }
        //输出所有除头节点之外的节点信息，需要遍历链表
        HeroNode temp = head.getNextNode();
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.getNextNode();
        }

    }

    private boolean isEmpty() {
        return this.head.getNextNode() == null;
    }
}
