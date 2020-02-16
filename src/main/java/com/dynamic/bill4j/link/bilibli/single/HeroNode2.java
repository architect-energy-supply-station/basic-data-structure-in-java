package com.dynamic.bill4j.link.bilibli.single;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/2/16
 */
public class HeroNode2 {
    private int no;
    private String name;
    private String nickName;
    private HeroNode2 next;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public HeroNode2 getNext() {
        return next;
    }

    public void setNext(HeroNode2 next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("no", no)
                .append("name", name)
                .append("nickName", nickName)
                .toString();
    }
}
