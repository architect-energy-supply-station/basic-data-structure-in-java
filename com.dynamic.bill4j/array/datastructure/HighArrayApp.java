package array.datastructure;

import java.util.Arrays;

/**
 * @description：
 * @author：by Administrator
 * @date：2020/1/15
 */
public class HighArrayApp {
    public static void main(String[] args) {
        HighArray array = new HighArray(20);
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
        array.display();
        int searchKey = 22;
        if (array.find(searchKey) == -1) {
            System.out.printf("没有找到元素 %d ", searchKey);

        } else {
            System.out.printf("元素 %d 的位置为 %d  ", searchKey,array.find(searchKey));
        }

        array.delete(22);
        array.delete(8);
        System.out.println();
        System.out.printf("数组中最大的元素的值为：%d", array.getMax());
        System.out.println();
        System.out.printf("数组中最小的元素的值为：%d", array.getMin());
        System.out.println();
        array.removeMax();
        array.display();

    //    实现倒序排序，要求不能修改原有的类
        long [] reversedArray = new long[20];
        for (int i = 0; i < reversedArray.length; i++) {
            long removedFromOriginArray = array.removeMax();
            if (removedFromOriginArray == -1) {
                reversedArray[i] = 0;
            } else {
                reversedArray[i] = removedFromOriginArray;
            }
        }
        System.out.println();
        System.out.println(Arrays.toString(reversedArray));
    }
}
