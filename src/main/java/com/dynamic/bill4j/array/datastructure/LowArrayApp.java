package com.dynamic.bill4j.array.datastructure;

/**
 * description：支持基本的数组增删改查操作
 *
 * @author Administrator
 * @date 2020/1/15
 * version:v1.0
 */
public class LowArrayApp {
    public static void main(String[] args) {
    //    声明定义数组存放10个运动员的号码，并初始化
        LowArray array = new LowArray(10);
        array.find(30);
        array.remove(35);
        array.remove(20);
        array.print();
    }
}
