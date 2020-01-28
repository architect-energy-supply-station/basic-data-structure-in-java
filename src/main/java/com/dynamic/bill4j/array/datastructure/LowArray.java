package com.dynamic.bill4j.array.datastructure;

import java.util.Arrays;

/**
 * description：支持基本的数组增删改查操作
 *
 * @author Administrator
 * @date 2020/1/15
 * version:v1.0
 */
public class LowArray {
    int[] arr;
    int indexOfForLoop=0;
    int eElement;
    public LowArray(int size) {
        //    声明定义数组存放10个运动员的号码，并初始化
        arr = new int[size];
        this.eElement=size;
        Arrays.parallelSetAll(arr, operand -> operand * 5);
        System.out.println(Arrays.toString(this.arr));
    }

    /**
     * 查找数组中的元素
     * @param searchKey 需要查找的关键字
     * @return 0表示找到该关键字，否则直接返回该关键字的位置
     */
    public int find(int searchKey) {
        for ( indexOfForLoop=0;indexOfForLoop<eElement;indexOfForLoop++) {
            if (searchKey == arr[indexOfForLoop]) {
                break;
            }
        }
        if (indexOfForLoop < eElement) {
            System.out.printf("您要查找的元素 %d 的索引位置为%d",searchKey,indexOfForLoop);
            System.out.println();
            return indexOfForLoop;
        } else {
            System.out.printf("没有发现您要查找的元素 %d",searchKey);
            return 0;
        }
    }

    public void remove(int item) {
        find(item);
        for (int k = 0; k < eElement ; k++) {
            // assert k+1 < eElement;
            if (k + 1 == eElement) {
                this.arr[k] = 0;
            } else {
                this.arr[k] = arr[k + 1];
            }
        }
        eElement--;
        System.out.printf( "元素 %d 已从容器中移除 !",item);
        System.out.println();
    }

    public void print() {
        System.out.println(Arrays.toString(this.arr));
    }

}
