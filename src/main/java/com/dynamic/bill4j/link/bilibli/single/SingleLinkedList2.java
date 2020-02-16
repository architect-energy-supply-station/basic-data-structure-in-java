package com.dynamic.bill4j.link.bilibli.single;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/2/16
 */
public class SingleLinkedList2 {
private int  count;
    private HeroNode2 head;

    public SingleLinkedList2() {
        this.head = new HeroNode2(0, "", "");
        this.count=0;

    }

    public int getCount() {
        return count;
    }

    public void add(HeroNode2 heroNode) {
    //    找到最后的节点
        //    借助辅助变量，遍历链表
        HeroNode2 temp = this.head;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
    //    将最后一个节点指针指向heroNode
        temp.setNext(heroNode);
        count++;
    }

    private boolean isEmpty() {
        return this.head.getNext() == null;
    }

    public void display() {
    //  遍历链表，输出每个节点的值
        verifyThatTheLinkedListIsEmpty();
        HeroNode2 temp = this.head;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            System.out.println(temp);
            temp=temp.getNext();
        }
    }

    private void verifyThatTheLinkedListIsEmpty() {
        if (isEmpty()) {
            System.out.println("链表为空！");
            throw new LinkedListEmptyException("链表为空！");
        }
    }

}
