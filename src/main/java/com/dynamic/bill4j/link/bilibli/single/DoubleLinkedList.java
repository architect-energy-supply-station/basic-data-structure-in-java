package com.dynamic.bill4j.link.bilibli.single;

import java.util.concurrent.atomic.LongAdder;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/2/15
 */
public class DoubleLinkedList {
    public DoubleHeroNode getHead() {
        return head;
    }

    private DoubleHeroNode head;
    private int count;

    public int getCount() {
        return count;
    }

    public DoubleLinkedList() {
        this.head = new DoubleHeroNode(0, "", "");
        this.count = 0;
    }
    //思路一：尾插法
    public void add(DoubleHeroNode heroNode) {
        //    先找到链表的最后：遍历链表，直到next的值为null，进行插入（将最后节点next的值指向新的node）
        //     加入辅助变量
        DoubleHeroNode temp = head;
        while (true) {
            if (temp.getNextNode() == null) {
                break;
            }
            temp = temp.getNextNode();
        }
        //next 节点指向新的Node
        temp.setNextNode(heroNode);
        heroNode.setPreviousNode(temp);
        count++;
    }

    //思路二：头插法
    public void  addToFirstNodeAlways(DoubleHeroNode heroNode)  {
        DoubleHeroNode cur = this.head;
        //头节点的下一个永远作为第一个节点
        if (cur.getNextNode() == null) {
            cur.setNextNode(heroNode);
            heroNode.setPreviousNode(cur);
        } else {
            //在原来的第一个节点进行插入
            heroNode.setNextNode(cur.getNextNode());
            cur.getNextNode().setPreviousNode(heroNode);
            cur.setNextNode(heroNode);
            heroNode.setPreviousNode(cur);

        }
        count++;
    }

    //考虑链表的有序性，每次插入保证链表是有序的
    public void addInOrder(DoubleHeroNode heroNode) {
        DoubleHeroNode temp = this.head;
        boolean enableInsertion = false;
        while (true) {
            if (temp.getNextNode() == null) {
                System.out.println("已到链表尾部~");
                enableInsertion = true;
                break;
            } else if (temp.getNextNode().getNumber() > heroNode.getNumber()) {
                enableInsertion = true;
                break;
            } else if (temp.getNextNode().getNumber() == heroNode.getNumber()) {
                break;
            }
            temp = temp.getNextNode();
        }
        if (enableInsertion) {
            heroNode.setNextNode(temp.getNextNode());
            heroNode.setPreviousNode(temp);
            temp.setNextNode(heroNode);
            count++;
        } else {
            System.out.println("no已存在,不允许重复插入！");
        }
    }

    public void remove(int no) {
    //    先找到要删除的节点的前一个结点，利用temp节点
        if (this.head == null) {
            System.out.println("空链表，没有可删除元素");
            return;
        }
        DoubleHeroNode temp = this.head.getNextNode();
        boolean enableRemove = false;
        while (true) {
            if (temp == null) {
                System.out.println("已经到达链表尾部！");
                break;
            } else if (temp.getNumber() == no) {
                enableRemove = true;
                break;
            }
            temp = temp.getNextNode();
        }
        if (enableRemove) {
            temp.getPreviousNode().setNextNode(temp.getNextNode());
            if (temp.getNextNode()!=null) {
                temp.getNextNode().setPreviousNode(temp.getPreviousNode());
            }
            count--;
            System.out.printf("成功移除节点 %d ", no);
            System.out.println("");
        } else {
            System.out.println("没有找到要移除的no对应的人物");
        }
    }

    public void update(DoubleHeroNode heroNode) {
        DoubleHeroNode temp = this.head;
        boolean enableUpdate = false;
        while (true) {
            if (temp.getNextNode() == null) {
                break;
            } else if (temp.getNumber() == heroNode.getNumber()) {
                enableUpdate = true;
                break;
            }
            temp = temp.getNextNode();
        }
        if (enableUpdate) {
            temp.setName(heroNode.getName());
            temp.setNickName(heroNode.getNickName());
        } else {
            System.out.printf("没有找到节点 %d ", heroNode.getNumber());
            System.out.println("");
        }
    }

    /**
     * 查找该链表中倒数第index个结点
     * @param head 要查找的链表的头结点
     * @param index 倒数第 {@code index } 个结点
     * @return 返回倒数第 index 个{@code DoubleHeroNode}
     * @throws NullPointerException if LinkedList node is empty
     */
    public DoubleHeroNode nodeOfLastIndex(DoubleHeroNode head, int index) {
        DoubleHeroNode temp = head;
        if (temp.getNextNode() == null) {
            return null;
        }
        int length = getLength(head);
        verifyIndexValidity(index, length);
        LongAdder count = new LongAdder();
        while (true) {
            if (temp.getNextNode() == null) {
                break;
            } else if (length-index == count.intValue()) {
                break;
            }
            temp = temp.getNextNode();
            count.increment();
        }
        return temp;
    }







    private void verifyIndexValidity(int index, int length) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("length = " + length + ", index = " + index);
        }
    }



    public static int getLength(DoubleHeroNode head) {
        DoubleHeroNode temp = head;
        int length = 0;
        if (temp.getNextNode() == null) {
            return length;
        }
        while (temp.getNextNode() != null) {
            temp = temp.getNextNode();
            length++;
        }
        return length;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("链表为空!");
        }
        //输出所有除头节点之外的节点信息，需要遍历链表
        DoubleHeroNode temp = head.getNextNode();
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.getNextNode();
        }

    }

    private static void verifyThatTheLinkedListIsEmpty(DoubleHeroNode heroNode) {
        if (isEmpty(heroNode)) {
            System.out.println("链表为空！");
        }
    }
    private boolean isEmpty() {
        return this.head.getNextNode() == null;
    }


    private static boolean isEmpty(DoubleHeroNode heroNode) {

        return heroNode.getNextNode() == null;
    }
}
