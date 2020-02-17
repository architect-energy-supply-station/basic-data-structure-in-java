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
    public void addInOrder(HeroNode heroNode) {
        HeroNode temp = this.head;
        boolean enableInsertion = false;
        while (true) {
            if (temp.getNextNode() == null) {
                System.out.println("已到链表尾部~");
                enableInsertion = true;
                break;
            } else if (temp.getNextNode().getNo() > heroNode.getNo()) {
                enableInsertion = true;
                break;
            } else if (temp.getNextNode().getNo() == heroNode.getNo()) {
                break;
            }
            temp = temp.getNextNode();
        }
        if (enableInsertion) {
            heroNode.setNextNode(temp.getNextNode());
            temp.setNextNode(heroNode);
            count++;
        } else {
            System.out.println("no已存在,不允许重复插入！");
        }
    }

    public void remove(int no) {
    //    先找到要删除的节点的前一个结点，利用temp节点
        HeroNode temp = this.head;
        boolean enableRemove = false;
        while (true) {
            if (temp.getNextNode() == null) {
                System.out.println("已经到达链表尾部！");
                break;
            } else if (temp.getNextNode().getNo() == no) {
                enableRemove = true;
                break;
            }
            temp = temp.getNextNode();
        }
        if (enableRemove) {
            //    将要删除的节点从temp节点移除，将temp的next指向，temp的下下个节点
            temp.setNextNode(temp.getNextNode().getNextNode());
            count--;
            System.out.printf("成功移除节点 %d ", no);
            System.out.println("");
        } else {
            System.out.println("没有找到要移除的no对应的人物");
        }
    }

    public void update(HeroNode heroNode) {
        HeroNode temp = this.head;
        boolean enableUpdate = false;
        while (true) {
            if (temp.getNextNode() == null) {
                break;
            } else if (temp.getNo() == heroNode.getNo()) {
                enableUpdate = true;
                break;
            }
            temp = temp.getNextNode();
        }
        if (enableUpdate) {
            temp.setName(heroNode.getName());
            temp.setNickName(heroNode.getNickName());
        } else {
            System.out.printf("没有找到节点 %d ", heroNode.getNo());
            System.out.println("");
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("链表为空!");
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
