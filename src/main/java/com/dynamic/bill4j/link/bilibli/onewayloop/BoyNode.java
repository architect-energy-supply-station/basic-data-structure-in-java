package com.dynamic.bill4j.link.bilibli.onewayloop;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/3/1
 */
public class BoyNode {
    private int no;
    private BoyNode next;

    public BoyNode(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public BoyNode getNext() {
        return next;
    }

    public void setNext(BoyNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("no", no)
                .append("next", next)
                .toString();
    }
}
