package com.dynamic.bill4j.link.foreignclassictextbook;

/**
 * @description：this is use to implements Link
 * @author：by Bill-liu
 * @date：2020/2/21
 */
public class Link2 {
    public int iData;
    public double dData;
    public Link2 next;

    public Link2(int iData, double dData
    ) {

        this.iData = iData;
        this.dData = dData;

    }

    public void displayLink() {
        System.out.println("iData ：" + iData + ", dData : " + dData);
    }
}
