package array.datastructure;

import java.util.Arrays;

/**
 * @description：
 * @author：by Administrator
 * @date：2020/1/15
 */
public class HighArray {
    private long[] array;
    private int eElement;

    public HighArray(int maxSize) {
        this.array = new long[maxSize];
        this.eElement = 0;
    }

    /**
     * 查找数组中是否包含某元素
     * @param searchKey 需要查找的关键字
     * @return 返回-1：表示没有找到，否则返回该元素在数组中的下标
     */
    public int find(long searchKey) {
        int j;
        for ( j = 0; j < eElement ; j++) {
            if (this.array[j]==searchKey) {
                break;
            }
        }
        if (j == eElement) {
            return -1;
        } else {
            return j;
        }
    }

    public void insert(long value) {
        this.array[eElement] = value;
        eElement++;
    }

    public boolean delete(long value) {
        int findResult = this.find(value);
        if (findResult ==-1) {
            return false;
        } else {
            for (int i = findResult ; i < eElement ; i++) {
                this.array[i] = this.array[i + 1];
            }
            eElement--;
            return true;
        }
    }

    public void display() {
        System.out.println();
        System.out.println(Arrays.toString(this.array));
    }
}
