package array.datastructure;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description：
 * @author：by Administrator
 * @version:v1.0
 * @date：2020/1/15
 */
public class OriginArray {
    public static void main(String[] args) {
        int i = 0;
        int[] array = new int[]{1,2,3,10,11,22,29,20,10,10};
        int eElement =10;
        System.out.println("打印原始数组的内容");
        System.out.println(Arrays.toString(array));

    //    查找关键字
        int searchKey =22;
        //只要查找任意一个匹配上的即返回
        i = find(array, eElement, searchKey);
        //    需要找到所有的出现该关键字的位置，并打印其索引位置
        printFindResult(eElement, i, searchKey);
    //    匹配到所有的关键字所在位置，并打印
    //
        System.out.println("出现关键字的位置分别是");
        System.out.println(findAll(array, eElement, 10));

    //     移除指定的元素
    //    先要找到这个元素，所在的位置
        searchKey=11;
        i = find(array, eElement, searchKey);
        for (int j = i; j < eElement; j++) {
            if (j+1 == eElement) {
                array[j] = 0;
            } else {
                array[j] = array[j+1];
            }
        }
        eElement--;
        System.out.printf("打印删除元素 %d 后的数组",searchKey);
        System.out.println();
        System.out.println(Arrays.toString(array));
        //     去除重复的元素

    //     对数组进行排序


    }

    private static void printFindResult(int eElement, int i, int searchKey) {
        if (i < eElement) {
            System.out.printf("您需要查找的关键字 %d 的位置为：%d ", searchKey, i);
            System.out.println();
        } else {
            System.out.printf("没有找到关键字 %d ",searchKey);
        }
    }

    private static int find(int[] array, int eElement, int searchKey) {
        int i;//    只要查找到一个就返回该关键字的索引位置，打印出来
        for (i = 0; i < eElement; i++) {
            if (array[i]==searchKey) {
                break;
            }
        }
        return i;
    }
    private static ArrayList findAll(int[] array, int eElement, int searchKey) {
        //    只要查找到所有的该关键字的索引位置，并打印出来
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int k = 0; k < eElement; k++) {
            if (array[k]==searchKey) {
                indexes.add(k);
            }
        }
        return indexes;
    }

}
