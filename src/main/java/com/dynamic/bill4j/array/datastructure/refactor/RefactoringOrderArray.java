package com.dynamic.bill4j.array.datastructure.refactor;

import org.apache.commons.lang3.mutable.MutableLong;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;


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

    public long[] getArray() {
        return array;
    }

    public int geteElement() {
        return eElement;
    }

    /**
     * <p>find the index of the given value in the array
     *
     * @param valueToFind value to find
     * @return the index of the value within the array
     * {@link #INDEX_NOT_FOUND ({@code -1}) if not found }
     */
    public int indexOf(final int valueToFind) {
        return indexOf(valueToFind, 0);
    }

    /**
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
        for (int i = startIndex; i < this.eElement; i++) {
            if (valueToFind == this.array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;

    }

    /**
     * 判断当前数组是否为空
     *
     * @return true为空，false非空
     */
    public boolean isEmpty() {
        return this.eElement == 0;
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
        return result != -1;
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
    public long removeMaxAndGet() {
        long max = this.getMax();
        if (max == -1) {
            return 0;
        }
        System.out.println();
        System.out.printf("当前数组的最大值为：%d ", max);
        System.out.println();
        System.out.println("开始移除最大值……");
        this.removeElement(max);
        return max;
    }

    /**
     * When the array is not empty, the largest element in the array is returned, because the array is an ordered array and is arranged in ascending order, so the last value is the maximum value
     *
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
     * <p>remove the specific element from the array</p>
     * <p>We assume that there are no duplicate elements in the array and the array is ordered</p>
     *
     * @param elementToRemove element to be remove
     * @return {@code false} could not find the element or something wrong when remove the element from array {@code true} removed
     * {@link #indexOf(long) ({@code -1}) if not found the element}
     */
    public boolean removeElement(long elementToRemove) {
        //    get the index of the element of remove
        int index = indexOf(elementToRemove);
        //    define a tempArray , destination array  must using the same type of the source array
        if (index == -1) {
            System.out.printf("没有找到您想要移除的元素 %d", elementToRemove);
            return false;
        } else {
            System.out.printf("元素 %d 将从数组中移除！", elementToRemove);
            return remove0(index);
        }
    }

    /**
     * <p>find the index of the given value in the array
     *
     * @param valueToFind value to find
     * @return the index of the value within the array
     * {@link #INDEX_NOT_FOUND ({@code -1}) if not found }
     */
    public int indexOf(final long valueToFind) {
        return indexOf(valueToFind, 0);
    }

    /**
     * remove the specific element from array through the index of the element
     *
     * @param index index of element
     * @return {@code true} if removed from array
     */
    private final boolean remove0(int index) {
        final Object result;
        try {
            result = Array.newInstance(this.array.getClass().getComponentType(), array.length - 1);
            System.arraycopy(this.array, 0, result, 0, index);
            if (index < array.length) {
                System.arraycopy(this.array, index + 1, result, index, array.length - index - 1);
                this.array = (long[]) result;
            }
        } catch (NegativeArraySizeException e) {
            e.printStackTrace();
            System.out.printf("移除失败！发生异常");
            return false;
        }
        System.out.println();
        this.eElement--;
        System.out.printf("移除成功！");
        return true;
    }

    /**
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
        for (int i = startIndex; i < this.eElement; i++) {
            if (valueToFind == this.array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;

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
        assert this.eElement < array.length;
        for (int i = this.eElement; i > insertIndex; i--) {
            this.array[i] = this.array[i - 1];
        }
        this.array[insertIndex] = value;
        eElement++;
    }

    public void insertWithDuplicate(long value) {
        //找到比当前插入元素大的位置，并对该位置进行标识（线性查找）
        // insertIndex = getInsertIndexByBinary(value);
        //比要插入元素大的数，逐个  后移
        assert this.eElement < array.length;

        this.array[eElement] = value;

        eElement++;
    }

    /**
     * delete element from array
     *
     * @param value value to be deleted
     * @return {@code true} if the element are removed
     * @since 1.0
     * @deprecated this method has been replaced by{@code com.dynamic.bill4j.array.datastructure.refactor.RefactoringOrderArray#removeElement(long)}
     * removed from future release
     */
    @Deprecated
    public boolean delete(long value) {
        // int result = this.find(value);
        int result = this.indexOf(value);
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

    //思路一：复用单个删除的算法，循环调用实现批量删除
    public boolean removeElements(final long... elementsToRemove) {
        if (isEmpty(elementsToRemove)) {
            return false;
        }
        boolean result = false;
        for (int i = 0; i < elementsToRemove.length; i++) {
            result = removeElement(elementsToRemove[i]);
        }

        return result;
    }

    /**
     * 判断当前数组是否为空
     *
     * @return true为空，false非空
     */
    public boolean isEmpty(final long[] array) {
        return array.length == 0;
    }

    //思路二：利用HashMap<Long,mutableLong>存储将要删除的对象,进行数量的增减，再通过BitSet进行标记，最后再进行删除
    public long[] removeElements(final long[] array, final long... values) {
        if (isEmpty(array) || isEmpty(values)) {
            return array.clone();
        }
        HashMap<Long, MutableLong> occurrences = new HashMap<Long, MutableLong>();
        for (long value : values) {
            Long boxed = Long.valueOf(value);
            MutableLong count = occurrences.get(boxed);
            if (count == null) {
                occurrences.put(boxed, new MutableLong(1));
            } else {
                count.increment();
            }
        }

        BitSet toRemove = new BitSet();
        for (int i = 0; i < array.length; i++) {
            long key = array[i];
            //TODO:final 关键字的区别 -- Bill-liu BuiltIn 2020/2/10 10:52
            MutableLong count = occurrences.get(key);
            if (count != null) {
                if (count.decrementAndGet() == 0) {
                    occurrences.remove(key);
                }
                toRemove.set(i);
            }
        }
        return (long[]) removeAll(array, toRemove);
    }


    private Object removeAll(Object array, BitSet remove) {
//TODO:使用static与否的区别  -- Bill-liu BuiltIn 2020/2/10 10:53
//第一步：声明所需要用到的变量
        int srcLength = Array.getLength(array);
        //items to sign true in bitset means item to be remove
        int removeVal = remove.cardinality();
        Object result = Array.newInstance(array.getClass().getComponentType(), srcLength - removeVal);
        int srcIndex = 0;
        int destinationIndex = 0;
        //需要拷贝的元素个数
        int count;
        //bitset中被标记的需要移除的元素（在bitset中值为1）的索引位置
        int set;
//第二步：while循环进行数组的移除操作，使用arrayCopy的方式
        while ((set = remove.nextSetBit(srcIndex)) != -1) {
            count = set - srcIndex;
            if (count > 0) {
                System.arraycopy(array, srcIndex, result, destinationIndex, count);
                destinationIndex += count;
            }
            srcIndex = remove.nextClearBit(set);
        }
        count = srcLength - srcIndex;
        if (count > 0) {
            System.arraycopy(array, srcIndex, result, destinationIndex, count);
        }
        this.eElement -= removeVal;
        this.array = (long[]) result;
        return result;
    }

    /**
     * remove the specific element from array,not like the private version , this one must be validate the index , cause you never know what gonna input by any other users
     *
     * @param index index of array
     * @return {@code false } index is  invalid or something is wrong when remove the element {@code true} removed
     * @throws IndexOutOfBoundsException
     */
    public final boolean remove(int index) {
        //Verify the legitimacy of the index
        int length = this.array.length;
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + length);
        }
        return remove0(index);
    }

    /**
     * 判断当前数组是否为空
     *
     * @return true为空，false非空
     */
    public boolean isEmpty(final int[] array) {
        return array.length == 0;
    }

    public final long[] removeAllAndGet(final int... indices) {
        int length = Array.getLength(array);
        int diff = 0;
        //处理输入的参数，拷贝和排序。为了安全，不被外部意外修改
        int[] clonedIndices = indices.clone();
        Arrays.sort(clonedIndices);

        //获取到有效的需要删除元素索引的个数,定义中间数组的关键变量
        if (!isEmpty(clonedIndices)) {
            //Verify the legitimacy of the index
            int i = clonedIndices.length;
            int preIndex = length;
            while (--i >= 0) {
                int index = clonedIndices[i];
                if (index < 0 || index >= length) {
                    throw new IndexOutOfBoundsException("index:" + index + ",length:" + length);
                }
                if (index >= preIndex) {
                    continue;
                }
                diff++;
                preIndex = index;
            }
        }

        Object result = Array.newInstance(array.getClass().getComponentType(), length - diff);
        if (diff < length) {
            //上次拷贝元素后一个位置
            int end = length;
            //剩余尚未拷贝的元素个数（即从左往右数的索引位置）
            int destinationIndex = length - diff;
            for (int i = clonedIndices.length - 1; i >= 0; i--) {
                int index = clonedIndices[i];
                if (end - index > 1) {
                    int cp = end - index - 1;
                    destinationIndex -= cp;
                    System.arraycopy(array, index + 1, result, destinationIndex, cp);
                }
                end = index;
            }
            //将左侧剩余的内容，拷贝出来
            if (end > 0) {
                System.arraycopy(array, 0, result, 0, end);
            }
        }
        //fixme:[bill] please fix the bug here and make sure it works --Bill-liu 2020/2/8 22:34
        //region 算法有问题
/*
        for (int i = 0; i < indices.length; i++) {
            reult = remove(indices[i]);
        }
*/
        //endregion

        eElement -= diff;
        array = (long[]) result;
        return (long[]) result;
    }

    public final void removeAllOccurrences(int element) {
        //    查找该元素
        int index = indexOf(element);
        if (index == INDEX_NOT_FOUND) {
            System.out.println("没有找到重复元素");
            return;
        }
        //    从数组存放起来,长度等于原数组减去第一次发现的位置
        int[] indices = new int[array.length - index];

        //    循环查找，每次查询从上次找到该元素的地方，往后一个位置继续开始
        indices[0] = index;
        int count = 1;
        while ((index = indexOf(element, indices[count - 1] + 1)) != INDEX_NOT_FOUND) {
            indices[count++] = index;
        }
        // Arrays.sort(indices);
        System.out.println(Arrays.toString(indices));
        int[] toRemove = (int[]) Array.newInstance(indices.getClass().getComponentType(), count - 1);
        System.out.println(Arrays.toString(toRemove));
        System.out.println("去重后的数组,保留第一个元素");
        System.arraycopy(indices, 1, toRemove, 0, count - 1);
        System.out.println("将要移除的元素索引值");
        System.out.println(Arrays.toString(toRemove));
        System.out.println("去重后的数组");
        System.out.println(Arrays.toString(removeAllAndGet(toRemove)));

        //    调用removeAllAndGet方法，进行批量移除
    }

    public final void removeAllOccurrences(long element) {
        //    查找该元素
        int index = indexOf(element);
        if (index == INDEX_NOT_FOUND) {
            System.out.println("没有找到重复元素");
            return;
        }
        //    从数组存放起来,长度等于原数组减去第一次发现的位置
        int[] indices = new int[array.length - index];

        //    循环查找，每次查询从上次找到该元素的地方，往后一个位置继续开始
        indices[0] = index;
        int count = 1;
        while ((index = indexOf(element, indices[count - 1] + 1)) != INDEX_NOT_FOUND) {
            indices[count++] = index;
        }
        // Arrays.sort(indices);
        System.out.println(Arrays.toString(indices));
        int[] toRemove = (int[]) Array.newInstance(indices.getClass().getComponentType(), count - 1);
        System.out.println(Arrays.toString(toRemove));
        System.out.println("去重后的数组,保留第一个元素");
        System.arraycopy(indices, 1, toRemove, 0, count - 1);
        System.out.println("将要移除的元素索引值");
        System.out.println(Arrays.toString(toRemove));
        System.out.println("去重后的数组");
        System.out.println(Arrays.toString(removeAllAndGet(toRemove)));

        //    调用removeAllAndGet方法，进行批量移除
    }

    public final void Deduplication() {
        for (int i = 0; i < eElement; i++) {
            removeAllOccurrences(array[i]);
        }
    }


    public void display() {
        System.out.println();
        System.out.println(Arrays.toString(this.array));
    }
}
