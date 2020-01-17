package array.datastructure;

import java.util.Arrays;

/**
 * @description：
 * @author：by Administrator
 * @date：2020/1/15
 */
public class OrderArrayWithMerge {
    private long[] array;
    private int eElement;


    public OrderArrayWithMerge(int maxSize) {
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
     * 当数组不为空时，返回该数组中最大的元素
     * @return max value of this array, if array is null return -1
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
        this.delete(max);
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

    public boolean delete(long value) {
        int result = this.find(value);
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

    public void display() {
        System.out.println();
        System.out.println(Arrays.toString(this.array));
    }
}
