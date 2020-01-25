package com.dynamic.bill4j.array.datastructure;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description：
 * @author：by Administrator
 * @date：2020/1/15
 */
public class HighArray {
    private long[] array;

    public int geteElement() {
        return eElement;
    }

    private int eElement;

    public HighArray(int maxSize) {
        this.array = new long[maxSize];
        this.eElement = 0;
    }

    /**
     * 返回数组中最大的元素的值
     *
     * @return 当数组为空，返回-1，否则返回数组中最大的元素
     */
    public long getMax() {
        long max = this.array[0];
        if (this.eElement == 0) {
            return -1;
        } else {
            for (int i = 0; i < this.eElement; i++) {
                if (this.array[i] > max) {
                    max = this.array[i];
                }
            }
            return max;
        }

    }

    /**
     * 返回数组中最小的元素的值
     *
     * @return 当数组为空，返回-1，否则返回数组中最小的元素
     */
    public long getMin() {
        long min
                = this.array[0];
        if (this.eElement == 0) {

            return -1;
        } else {
            for (int i = 0; i < this.eElement; i++) {
                if (this.array[i] < min
                ) {
                    min
                            = this.array[i];
                }
            }
            return min
                    ;
        }

    }

    /**
     * 移除数组中最大的值
     * @return 当数组中已经没有元素时，返回 0
     */
    public long removeMax() {
        long max = this.getMax();
        if (max==-1) {
            return 0;
        }
        System.out.println();
        System.out.printf("开始移除数组中的最大值：%d ", max);
        this.delete(max);
        return max;
    }

    public void insert(long value) {
        this.array[eElement] = value;
        eElement++;
    }

    public boolean delete(long value) {
        int findResult = this.find(value);
        if (findResult == -1) {
            return false;
        } else {
            for (int i = findResult; i < eElement; i++) {
                this.array[i] = this.array[i + 1];
            }
            eElement--;
            System.out.println();
            System.out.printf("元素 %d 移除成功！",value);
            return true;
        }
    }

    /**
     * 查找数组中是否包含某元素
     *
     * @param searchKey 需要查找的关键字
     * @return 返回-1：表示没有找到，否则返回该元素在数组中的下标
     */
    public int find(long searchKey) {
        int j;
        for (j = 0; j < eElement; j++) {
            if (this.array[j] == searchKey) {
                break;
            }
        }
        if (j == eElement) {
            return -1;
        } else {
            return j;
        }
    }

    /**
     * 查找符合该关键字的所在位置，并返回其索引位置
     * @param array 目标对象
     * @param eElement 元素的个数
     * @param searchKey 查找官关键字
     * @return 返回该关键字所在的索引位置的集合
     */
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
    public void display() {
        System.out.println();
        System.out.println(Arrays.toString(this.array));
    }
}
