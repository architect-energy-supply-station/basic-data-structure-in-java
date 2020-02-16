package com.dynamic.bill4j.link.bilibli.single;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/2/15
 */
public class HeroNode {
    private int no;
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
                .append("no", no)
                .append("name", name)
                .append("nickName", nickName)
                .toString();
    }

    public HeroNode(int no, String name, String nickName) {

        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }
}
