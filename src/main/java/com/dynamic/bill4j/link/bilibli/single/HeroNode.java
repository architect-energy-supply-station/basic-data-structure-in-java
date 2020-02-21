package com.dynamic.bill4j.link.bilibli.single;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/2/15
 */
public class HeroNode  {
    private Integer number;
    private static boolean isEmpty(HeroNode heroNode) {

        return heroNode.getNextNode() == null;
    }

    //打印倒序后的链表
    public static void display(HeroNode head) {
        if (isEmpty(head)) {
            System.out.println("链表为空!");
        }
        //输出所有除头节点之外的节点信息，需要遍历链表
        HeroNode temp = head;
        while (true) {
            if (temp.getNextNode() == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.getNextNode();
        }

    }
    public void display() {
        if (isEmpty(this)) {
            System.out.println("链表为空!");
        }
        //输出所有除头节点之外的节点信息，需要遍历链表
        HeroNode temp = this;
        while (true) {
            if (temp.getNextNode() == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.getNextNode();
        }

    }

    public String getNickName() {
        return nickName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    private String name;
    private String nickName;

    public HeroNode getNextNode() {
        return nextNode;
    }

    private HeroNode nextNode;

    public void setNextNode(HeroNode nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("no", number)
                .append("name", name)
                .append("nickName", nickName)
                .toString();
    }

    public HeroNode() {
    }

    public HeroNode(Integer number, String name, String nickName) {

        this.number = number;
        this.name = name;
        this.nickName = nickName;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
