package com.dynamic.bill4j.array.datastructure;

import java.util.Arrays;

/**
 * @description：
 * @author：by Administrator
 * @date：2020/1/15
 */
public class OrderArrayWIthMergeApp {
    public static void main(String[] args) {
        OrderWithMergeArray array = new OrderWithMergeArray(20);
        array.insert(2);
        array.insert(12);
        array.insert(22);
        array.insert(5);
        array.insert(8);
        array.insert(23);
        array.insert(25);
        array.insert(28);
        array.insert(21);
        array.insert(99);
        array.insert(24,array.getInsertIndexByBinary(24));
        array.insert(100,array.getInsertIndexByBinary(100));
        array.display();
        int[] array1 = new int[]{1,22,33,44};
        int[] array0;
        int[] array2=new int[]{1,25,31};
        array0 = OrderWithMergeArray.addAllOrdered(array1, array2);
        System.out.println(Arrays.toString(array0));

    }
}
