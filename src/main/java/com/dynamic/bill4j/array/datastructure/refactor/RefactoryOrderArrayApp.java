package com.dynamic.bill4j.array.datastructure.refactor;

/**
 * @description：
 * @author：by Administrator
 * @date：2020/1/15
 */
public class RefactoryOrderArrayApp {
    public static void main(String[] args) {
        RefactoringOrderArray array = new RefactoringOrderArray(20);
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
        int searchKey = 6;
        int result =array.indexOf(searchKey);
        if (result == -1) {
            System.out.printf("没有找到元素 %d ", searchKey);

        } else {
            System.out.printf("元素 %d 的位置为 %d  ", searchKey,result);
        }

        // array.delete(22);
        array.removeElement(22);
        array.removeElement(8);
        array.remove(2);
        // array.delete(8);
        array.display();
        System.out.printf("该数组中的最大值为： %d ",array.getMax());
        System.out.println();
        System.out.printf("该数组中的最小值为： %d ",array.getMin());
        array.removeMax();
        array.display();
    }
}
