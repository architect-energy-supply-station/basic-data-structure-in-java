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

    public void addInOrder(HeroNode2 heroNode) {
        HeroNode2 temp = this.head;
        boolean allowInsertion = false;
        while (true) {
            if (temp.getNext() == null) {
                System.out.println("已到达链表的尾部！");
                allowInsertion = true;
                break;
            } else if (temp.getNext().getNo() > heroNode.getNo()) {
                allowInsertion = true;
                break;
            } else if (temp.getNext().getNo() == heroNode.getNo()) {
                break;
            }
            temp = temp.getNext();
        }
        if (allowInsertion) {
            //顺序很重要！先修改下游，再修改上游！
            heroNode.setNext(temp.getNext());
            temp.setNext(heroNode);
            count++;
        } else {
            System.out.println("编号已存在，不允许插入重复编号！");
        }
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
            temp=temp.getNext();
            System.out.println(temp);
        }
    }

    private void verifyThatTheLinkedListIsEmpty() {
        if (isEmpty()) {
            System.out.println("链表为空！");
        }
    }

}
