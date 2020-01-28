package com.dynamic.bill4j.array.datastructure.refactor;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @description：
 * @author：by Administrator
 * @date：2020/1/15
 */
public class RefactoringOrderArray {
    /**
     * The index value when an element is not found in a list or array: {@code -1}.
     * This value is returned by methods in this class and can also be used in comparisons with values returned by
     * various method from {@link java.util.List}.
     */
    public static final int INDEX_NOT_FOUND = -1;
    private long[] array;
    private int eElement;


    public RefactoringOrderArray(int maxSize) {
        this.array = new long[maxSize];
        this.eElement = 0;
    }

    /**
     * 查找数组中是否包含某元素
     * @param searchKey 需要查找的关键字
     * @return 返回-1：表示没有找到，否则返回该元素在数组中的下标
     */
    public int find(long searchKey) {
        int upperBound=this.eElement-1;
        int lowerBound=0;
        int currentIndex;

        while (true) {
            currentIndex = (lowerBound + upperBound) / 2;
            if (this.array[currentIndex] == searchKey) {
                return currentIndex;
            } else if (lowerBound>upperBound) {
                return -1;
            } else {//将搜索区间缩小一半

                if (this.array[currentIndex] < searchKey) {
                     lowerBound=  currentIndex + 1;
                } else {
                    upperBound = currentIndex - 1;
                }
            }
        }
    }

    /**
     * <p>find the index of the given value in the array
     *
     * @param valueToFind value to find
     * @return the index of the value within the array
     *{@link #INDEX_NOT_FOUND ({@code -1}) if not found }
     */
    public int indexOf(final int valueToFind) {
        return indexOf(valueToFind, 0);
    }
    /**
     * <p>find the index of the given value in the array
     *
     * @param valueToFind value to find
     * @return the index of the value within the array
     *{@link #INDEX_NOT_FOUND ({@code -1}) if not found }
     */
    public int indexOf(final long valueToFind) {
        return indexOf(valueToFind, 0);
    }

    /**
     *
     * @param valueToFind
     * @param startIndex
     * @return
     */
    public int indexOf(final int valueToFind, int startIndex) {
        //验证startIndex
        if (startIndex < 0) {
            startIndex = 0;
        }
        //    遍历数组
        for (int i = startIndex ; i < this.eElement; i++) {
            if (valueToFind == this.array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;

    }
    /**
     *
     * @param valueToFind
     * @param startIndex
     * @return
     */
    public int indexOf(final long valueToFind, int startIndex) {
        //验证startIndex
        if (startIndex < 0) {
            startIndex = 0;
        }
        //    遍历数组
        for (int i = startIndex ; i < this.eElement; i++) {
            if (valueToFind == this.array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;

    }
    /**
     * 判断当前数组是否为空
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
     * 判断该元素是否在数组中重复出现
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
     * 使用二分查找法，寻找数组中合适的插入位置
     * @return 返回要插入位置所在下标
     */
    public int getInsertIndexByBinary(long item) {
        if (this.duplicated(item)) {
            throw new RuntimeException("不允许插入重复元素！");
        }
        if (item < this.array[0] || this.eElement==0) {
            return 0;
        }
        if (item > this.array[eElement - 1]) {
            return this.eElement;
        }
        int upperBound=this.eElement-1;
        int lowerBound=0;
        int currentIndex;
        while (true) {
            currentIndex = (lowerBound + upperBound) / 2;
            //此时，二分查找区间为零
            if (lowerBound == upperBound) {
                if (this.array[currentIndex] > item) {
                    return currentIndex ;
                } else {
                    return currentIndex+1;
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
     * When the array is not empty, the largest element in the array is returned, because the array is an ordered array and is arranged in ascending order, so the last value is the maximum value
     * @return max value of this com.dynamic.bill4j.array, if com.dynamic.bill4j.array is null return -1
     */
    public long getMax() {
    //    如果数组为空，则返回-1
        if (this.eElement == 0) {
            return INDEX_NOT_FOUND;
        } else {
            return this.array[eElement - 1];
        }
    }

    /**
     * 返回当前数组中最大元素，并且将其从数组中移除掉
     * @return 返回当前数组的最大元素，若数组为空， 则返回 0
     */
    public long removeMax() {
        long max = this.getMax();
        if (max==-1) {
            return 0;
        }
        System.out.println();
        System.out.printf("当前数组的最大值为：%d ",max);
        System.out.println();
        System.out.println("开始移除最大值……");
        this.removeElement(max);
        return max;
    }

    /**
     * 当数组不为空时，返回数组中的最小元素
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
     * @param value 需要插入的元素
     */
    public void insert(long value) {
        int insertIndex ;
        //找到比当前插入元素大的位置，并对该位置进行标识（线性查找）
        insertIndex = getInsertIndexByLinear(value);
        // insertIndex = getInsertIndexByBinary(value);
        //比要插入元素大的数，逐个  后移
        insert(value, insertIndex);
    }
    /**
     * 保持住数组的有序性，每次插入将数插入到正确合适的位置
     * @param value 需要插入的元素
     */
    public void insertNoDuplicate(long value) {
        int insertIndex ;
        if (this.duplicated(value)) {
            throw new RuntimeException("元素不允许重复！");
        }
        //找到比当前插入元素大的位置，并对该位置进行标识（线性查找）
        insertIndex = getInsertIndexByLinear(value);
        // insertIndex = getInsertIndexByBinary(value);
        //比要插入元素大的数，逐个  后移
        insert(value, insertIndex);
    }

    public void insert(long value, int insertIndex) {
        for (int i = this.eElement; i > insertIndex; i--) {
            this.array[i] = this.array[i - 1];
        }
        this.array[insertIndex] = value;
        eElement++;
    }

    private int getInsertIndexByLinear(long value) {
        int j;
        for (j = 0; j < this.eElement; j++) {
            if (this.array[j]>value) {
             break;
            }
        }
        return j;
    }

    /**
     * delete element from array
     * @param value value to be deleted
     * @return {@code true} if the element are removed
     * @deprecated this method has been replaced by{@code com.dynamic.bill4j.array.datastructure.refactor.RefactoringOrderArray#removeElement(long)}
     * removed from future release
     * @since 1.0
     */
    @Deprecated
    public boolean delete(long value) {
        // int result = this.find(value);
        int result = this.indexOf(value);
        if (result ==-1) {
            return false;
        } else {
            for (int i = result ; i < eElement ; i++) {
                this.array[i] = this.array[i + 1];
            }
            eElement--;
            System.out.println();
            System.out.printf("元素 %d 成功从数组中移除！",value);
            return true;
        }
    }

    /**
     * <p>remove the specific element from the array</p>
     * <p>We assume that there are no duplicate elements in the array and the array is ordered</p>
     * @param elementToRemove element to be remove
     * @return {@code false} could not find the element or something wrong when remove the element from array {@code true} removed
     * {@link #indexOf(long) ({@code -1}) if not found the element}
     */
    public boolean removeElement(long elementToRemove) {
    //    get the index of the element of remove
        int index = indexOf(elementToRemove);
    //    define a tempArray , destination array  must using the same type of the source array
        if (index == -1) {
            System.out.printf("没有找到您想要移除的元素 %d",elementToRemove);
            return false;
        } else {
            System.out.printf("元素 %d 将从数组中移除！", elementToRemove);
            return remove0(index);
        }
    }

    /**
     * remove the specific element from array through the index of the element
     * @param index index of element
     * @return {@code true} if removed from array
     */
    private final  boolean remove0(int index) {
        final Object result;
        try {
            result = Array.newInstance(this.array.getClass().getComponentType(), this.eElement);
            System.arraycopy(this.array, 0, result, 0, index);
            if (index < this.eElement) {
                System.arraycopy(this.array, index + 1, result, index, this.eElement - index);
                this.array = (long[]) result;
            }
        } catch (NegativeArraySizeException e) {
            e.printStackTrace();
            System.out.printf("移除失败！发生未知异常");
            return false;
        }
        System.out.println();
        this.eElement--;
        System.out.printf("移除成功！");
        return true;
    }

    /**
     * remove the specific element from array,not like the private version , this one must be validate the index , cause you never know what gonna input by any other users
     * @param index index of array
     * @return {@code false } index is  invalid or something is wrong when remove the element {@code true} removed
     * @throws IndexOutOfBoundsException
     */
    public final boolean remove(int index) {
        //Verify the legitimacy of the index
        int length = this.array.length;
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Length: "+length);
        }
        return remove0(index);
    }


    public void display() {
        System.out.println();
        System.out.println(Arrays.toString(this.array));
    }
}
