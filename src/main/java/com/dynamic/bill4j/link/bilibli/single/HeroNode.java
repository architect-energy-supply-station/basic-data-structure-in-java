package com.dynamic.bill4j.link.bilibli.single;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/2/15
 */
public class HeroNode  {
    private Integer number;


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
