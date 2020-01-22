package com.dynamic.bill4j.array.datastructure;

/**
 * @description：
 * @author：by Administrator
 * @date：2020/1/15
 */
public class OrderArrayNoDuplicatedApp {
    public static void main(String[] args) {
        OrderArrayWithNoDuplicate array = new OrderArrayWithNoDuplicate(20);
        array.insert(2);
        array.insert(12);
        array.insert(22);
        array.insert(5);
        array.insert(5);
        array.insert(8);
        array.insert(23);
        array.insert(25);
        array.insert(28);
        array.insert(23);
        array.insert(23);
        array.insert(23);
        array.insert(21);
        array.insert(99);
        array.insert(99);
        array.insert(99);
        array.insert(99);
        array.display();
        System.out.println(array.getDuplicatedItemIndexes());
        array.noDuplicateItemKeepFirstItem(array.getDuplicatedItemIndexes());
        array.display();
    }
}
