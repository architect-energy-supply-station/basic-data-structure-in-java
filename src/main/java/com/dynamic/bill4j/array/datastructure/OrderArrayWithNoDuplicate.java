package com.dynamic.bill4j.array.datastructure;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description：
 * @author：by Administrator
 * @date：2020/1/15
 */
public class OrderArrayWithNoDuplicate {
    public static final int TO_BE_DELETED = -1;
    private long[] array;
    private int eElement;


    public OrderArrayWithNoDuplicate(int maxSize) {
        this.array = new long[maxSize];
        this.eElement = 0;
    }

    /**
     * 判断当前数组是否为空
     *
     * @return true为空，false非空
     */
    public boolean isEmpty() {
        if (this.eElement == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 使用二分查找法，寻找数组中合适的插入位置
     *
     * @return 返回要插入位置所在下标
     */
    public int getInsertIndexByBinary(long item) {
        if (this.duplicated(item)) {
            throw new RuntimeException("不允许插入重复元素！");
        }
        if (item < this.array[0] || this.eElement == 0) {
            return 0;
        }
        if (item > this.array[eElement - 1]) {
            return this.eElement;
        }
        int upperBound = this.eElement - 1;
        int lowerBound = 0;
        int currentIndex;
        while (true) {
            currentIndex = (lowerBound + upperBound) / 2;
            //此时，二分查找区间为零
            if (lowerBound == upperBound) {
                if (this.array[currentIndex] > item) {
                    return currentIndex;
                } else {
                    return currentIndex + 1;
                }
            } else {
                //将搜索区间缩小一半

                if (this.array[currentIndex] < item) {
                    //高区间
                    lowerBound = currentIndex + 1;

                } else {
                    //低区间
                    upperBound = currentIndex - 1;
                }

            }
        }

    }

    /**
     * 判断该元素是否在数组中重复出现
     *
     * @param item 元素的值
     * @return false表示没有重复，true表示重复
     */
    public boolean duplicated(long item) {
        int result = this.findByBinarySearch(item);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 查找数组中是否包含某元素,使用二分查找的方式进行（warning：如果没有经过排序处理的数组，
     * 使用二分查找结果会有问题）
     * @param searchKey 需要查找的关键字
     * @return 返回-1：表示没有找到，否则返回该元素在数组中的下标
     */
    public int findByBinarySearch(long searchKey) {
        int upperBound = this.eElement - 1;
        int lowerBound = 0;
        int currentIndex;

        while (true) {
            currentIndex = (lowerBound + upperBound) / 2;
            if (this.array[currentIndex] == searchKey) {
                return currentIndex;
            } else if (lowerBound > upperBound) {
                return -1;
            } else {//将搜索区间缩小一半

                if (this.array[currentIndex] < searchKey) {
                    lowerBound = currentIndex + 1;
                } else {
                    upperBound = currentIndex - 1;
                }
            }
        }
    }

    /**
     * 去除重复元素，并保留第一个出现的元素
     */
    public void noDuplicateItemKeepFirstItem() {
        this.noDuplicateItemKeepFirstItem(this.getDuplicatedItemIndexes());
    }

    /**
     * 去除重复元素，并保持序列中的第一个元素不被删除
     *
     * @param duplicatedItemIndexes 出现重复元素的位置集合
     * @return true表示移除成功，false表示移除失败
     */
    public void noDuplicateItemKeepFirstItem(@NotNull Set duplicatedItemIndexes) {
        // duplicatedItemIndexes.forEach(index -> this.remove(index));
        for (Object index : duplicatedItemIndexes) {
            this.array[(int)index] = TO_BE_DELETED;
        }
        // System.out.println("排序前");
        // this.display();
        // Arrays.sort(this.com.dynamic.bill4j.array);
        // System.out.println("排序后的结果");
        this.display();
        for (int i = 0; i < this.array.length; i++) {
            this.delete(TO_BE_DELETED);
        }
    }

    /**
     * 获取所有重复元素的索引位置
     *
     * @return
     */
    public Set getDuplicatedItemIndexes() {
        //TODO: need to refactoring ,using array instead of using set. 参考Apache和jdk的去重、删除算法 -- Bill-liu BuiltIn 2020/2/7 22:48
        Set duplicatedItemIndexes = new HashSet();

        for (int i = 0; i < this.eElement; i++) {
            ArrayList locations;
            locations = this.findLocations(this.array, this.eElement, this.array[i]);
            if (locations.size() > 1) {
                //只留下重复元素的第一个索引位置
                for (int j = 1; j < locations.size(); j++) {
                    if (!duplicatedItemIndexes.contains(locations)) {
                        duplicatedItemIndexes.add(locations.get(j));
                    }
                }
            }
        }
        return duplicatedItemIndexes;
    }


    /**
     * 查找符合该关键字的所在位置，并返回其索引位置
     *
     * @param array     目标对象
     * @param eElement  元素的个数
     * @param searchKey 查找官关键字
     * @return 返回该关键字所在的索引位置的集合
     */
    private ArrayList findLocations(long[] array, int eElement, long searchKey) {
        //    只要查找到所有的该关键字的索引位置，并打印出来
        ArrayList<Integer> indexes = new ArrayList<>(this.eElement);
        for (int k = 0; k < eElement; k++) {
            if (array[k] == searchKey) {
                indexes.add(k);
            }
        }
        return indexes;
    }


    /**
     * 返回当前数组中最大元素，并且将其从数组中移除掉
     *
     * @return 返回当前数组的最大元素，若数组为空， 则返回 0
     */
    public long removeMax() {
        long max = this.getMax();
        if (max == -1) {
            return 0;
        }
        System.out.println();
        System.out.printf("当前数组的最大值为：%d ", max);
        System.out.println();
        System.out.println("开始移除最大值……");
        this.delete(max);
        return max;
    }

    /**
     * 当数组不为空时，返回该数组中最大的元素
     *
     * @return max value of this com.dynamic.bill4j.array, if com.dynamic.bill4j.array is null return -1
     */
    public long getMax() {
        //    如果数组为空，则返回-1
        if (this.eElement == 0) {
            return -1;
        } else {
            return this.array[eElement - 1];
        }
    }
    /**
     * 查找数组中是否包含某元素
     *
     * @param searchKey 需要查找的关键字
     * @return 返回-1：表示没有找到，否则返回该元素在数组中的下标
     */
    public int findByLinear(long searchKey) {
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
     * 移除指定元素
     *
     * @param value 需要移除的元素
     * @return true 移除成功，false 移除失败
     */
    public boolean delete(long value) {
        int result = this.findByLinear(value);
        // int result = this.findByBinarySearch(value);
        if (result == -1) {
            return false;
        } else {
            for (int i = result; i < this.array.length; i++) {
                if (i+1>this.eElement) {
                    this.array[i] = 0;
                    break;
                }
                this.array[i] = this.array[i + 1];
            }
            eElement--;
            System.out.println();
            System.out.printf("元素 %d 成功从数组中移除！", value);
            this.display();
            return true;
        }
    }

    /**
     * 当数组不为空时，返回数组中的最小元素
     *
     * @return -1表示，该数组为空，否则返回最小元素的值
     */
    public long getMin() {
        if (this.eElement == 0) {
            return -1;
        } else {
            return this.array[0];
        }
    }

    /**
     * 保持住数组的有序性，每次插入将数插入到正确合适的位置
     *
     * @param value 需要插入的元素
     */
    public void insert(long value) {
        int insertIndex;
        //找到比当前插入元素大的位置，并对该位置进行标识（线性查找）
        insertIndex = getInsertIndexByLinear(value);
        // insertIndex = getInsertIndexByBinary(value);
        //比要插入元素大的数，逐个  后移
        insert(value, insertIndex);
    }

    private int getInsertIndexByLinear(long value) {
        int j;
        for (j = 0; j < this.eElement; j++) {
            if (this.array[j] > value) {
                break;
            }
        }
        return j;
    }

    public void insert(long value, int insertIndex) {
        for (int i = this.eElement; i > insertIndex; i--) {
            this.array[i] = this.array[i - 1];
        }
        this.array[insertIndex] = value;
        eElement++;
    }

    public void display() {
        System.out.println();
        System.out.println(Arrays.toString(this.array));
    }
}
