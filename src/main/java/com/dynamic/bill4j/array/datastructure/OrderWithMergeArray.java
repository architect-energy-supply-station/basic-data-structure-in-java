package com.dynamic.bill4j.array.datastructure;

import java.util.Arrays;

/**
 * @description：
 * @author：by Administrator
 * @date：2020/1/15
 */
public class OrderWithMergeArray {
    private long[] array;
    private int eElement;


    public OrderWithMergeArray(int maxSize) {
        this.array = new long[maxSize];
        this.eElement = 0;
    }

    /**
     * Adds all the elements of the given arrays into a new com.dynamic.bill4j.array.
     * <p>
     * The new com.dynamic.bill4j.array contains all of the element of array1 followed by all of the elements array2. When an com.dynamic.bill4j.array is returned, it is always a new com.dynamic.bill4j.array. Order is not guaranteed, the default is to add the contents of the second com.dynamic.bill4j.array after the first com.dynamic.bill4j.array
     *
     * @param array1 the first com.dynamic.bill4j.array whose elements are added to the new com.dynamic.bill4j.array.
     * @param array2 the second com.dynamic.bill4j.array whose elements are added to the new com.dynamic.bill4j.array.
     * @return The new int[] com.dynamic.bill4j.array.
     */
    //todo 不能使用可变参数？很奇怪！！！
    public static int[] addAll(final int[] array1, final int... array2) {
        int maxSize = array1.length + array2.length;
        int[] mergedArray = new int[maxSize];
        addAll(array1, array2, mergedArray);
        return mergedArray;
    }

    private static void addAll(int[] array1, int[] array2, int[] mergedArray) {
        int i;
        for (i = 0; i < array1.length; i++) {
            mergedArray[i] = array1[i];
        }
        System.out.println(Arrays.toString(mergedArray));
        for (int j = 0; j < array2.length; j++) {
            mergedArray[i++] = array2[j];
        }
    }

    /**
     * Adds all the elements of the given arrays into a new com.dynamic.bill4j.array.
     * <p>
     * The new com.dynamic.bill4j.array contains all of the element of array1 followed by all of the elements array2. When an com.dynamic.bill4j.array is returned, it is always a new com.dynamic.bill4j.array.
     *
     * @param array1 the first com.dynamic.bill4j.array whose elements are added to the new com.dynamic.bill4j.array.
     * @param array2 the second com.dynamic.bill4j.array whose elements are added to the new com.dynamic.bill4j.array.
     * @return The new int[] com.dynamic.bill4j.array.
     */
    //todo 保证有序,且不重复
    public static int[] addAllWithNoDuplicated(int[] array1, int[] array2) {
        int maxSize = array1.length + array2.length;
        int[] mergedArray = new int[maxSize];
        addAll(array1, array2, mergedArray);
        return mergedArray;
    }

    /**
     * Adds all the elements of the given arrays into a new com.dynamic.bill4j.array.
     * <p>
     * The new com.dynamic.bill4j.array contains all of the element of array1 followed by all of the elements array2. When an com.dynamic.bill4j.array is returned, it is always a new com.dynamic.bill4j.array.
     *
     * @param array1 the first com.dynamic.bill4j.array whose elements are added to the new com.dynamic.bill4j.array.
     * @param array2 the second com.dynamic.bill4j.array whose elements are added to the new com.dynamic.bill4j.array.
     * @return The new int[] com.dynamic.bill4j.array.
     */
    //todo 保证有序，但可能存在重复值
    public static int[] addAllOrdered(int[] array1, int[] array2) {
        int maxSize = array1.length + array2.length;
        int[] mergedArray = new int[maxSize];
        // addAll(array1, array2, mergedArray);
        //思路一：先按默认的顺序，依次将两个数组添加进来，再进行排序
        // Arrays.sort(mergedArray);
        //思路二：先进行排序，然后再进行逐一添加, 即每次取出两个数组中的最小值添加到合并的数组中
        addAll0(array1, array2, mergedArray);


        return mergedArray;
    }

    //前提是：两个有序的数组
    private static void addAll0(int[] array1, int[] array2, int[] mergedArray) {
       /* int i;
        int index = 0;
        int j ;
        for (i = 0; i < array1.length; i++) {
            for (j = 0; j < array2.length; j++) {
                if (array1[i] > array2[j]) {
                    mergedArray[i++] = array1[i++];
                    break;
                } else {
                    mergedArray[i++] = array2[j++];
                    break;
                }
            }
        }*/

        int a = 0;
        int b = 0;
        for (int i = 0; i < mergedArray.length; i++) {
            if (a < array1.length && b < array2.length) {   //两数组都未遍历完，相互比较后加入
                if (array1[a] > array2[b]) {
                    mergedArray[i] = array2[b];
                    b++;
                } else {
                    mergedArray[i] = array1[a];
                    a++;
                }
            } else if (a < array1.length) {   //array2已经遍历完，无需比较，直接将剩余array1加入
                mergedArray[i] = array1[a];
                a++;
            } else if (b < array2.length) {    //array1已经遍历完，无需比较，直接将剩余array2加入
                mergedArray[i] = array2[b];
                b++;
            }
        }


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
        int result = this.find(item);
        if (result == -1) {
            return false;
        } else {
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

    public boolean delete(long value) {
        int result = this.find(value);
        if (result == -1) {
            return false;
        } else {
            for (int i = result; i < eElement; i++) {
                this.array[i] = this.array[i + 1];
            }
            eElement--;
            System.out.println();
            System.out.printf("元素 %d 成功从数组中移除！", value);
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

    /**
     * 保持住数组的有序性，每次插入将数插入到正确合适的位置
     *
     * @param value 需要插入的元素
     */
    public void insertNoDuplicate(long value) {
        int insertIndex;
        if (this.duplicated(value)) {
            throw new RuntimeException("元素不允许重复！");
        }
        //找到比当前插入元素大的位置，并对该位置进行标识（线性查找）
        insertIndex = getInsertIndexByLinear(value);
        // insertIndex = getInsertIndexByBinary(value);
        //比要插入元素大的数，逐个  后移
        insert(value, insertIndex);
    }

    public void display() {
        System.out.println();
        System.out.println(Arrays.toString(this.array));
    }
}
