package com.dynamic.bill4j.array.queue;

import java.util.Arrays;

/**
 * @author bill-smith liuwb
 * @Package com.dynamic.bill4j.array.queue
 * @Date 2020/1/6 11:46
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
public class ArrayCircularQueue {

    public static final int EMPTY_QUEUE = -1;
    //用来表示队列的第一个元素，初始值为0
    private int front;
    //用来表示队列的最后一个元素的后一个位置，留出一个空间
    private int rear;
    //最大值（因为有一个空间预留，故有效值的最大个数应该是maxsize-1
    private int maxSize;
    private int size;

    public int getSize() {
        return size = (this.rear + maxSize - this.front) % maxSize;
    }

    private int[] queue;

    public ArrayCircularQueue(int maxSize) {
        this.front = 0;
        this.rear = 0;
        this.size = 0;
        this.maxSize = maxSize;
        this.queue = new int[maxSize];
    }

    /**
     * 首位相接时，表示队列已空。可能均为0，也可能均为最大值
     * @return true表示空，false表示非空
     */
    public boolean isEmpty() {
        return this.rear == this.front;
    }

    /**
     * 尾部的后一个位置再加一，取模后等于队首，表示队列已满
     * @return true 表示队列满，false表示未满
     */
    public boolean isFull() {
        return (this.rear + 1) % maxSize == this.front;
    }

    /**
     * 往队列添加元素，入队列操作
     * @param item 需要添加的元素
     */
    public void push(int item) {
//       需要检查元素的合法性，入参校验：这里使用最简单的校验方式，抛出illegalArgumentsExceptions。作为demo，暂不做
//        判断队列是否满
        if (this.isFull()) {
            throw new QueueFullException("队列已满！无法继续添加");
        }
        //需要取模，因为是环形的，位置是变化的，如果一直加，会出现数组越界
        this.queue[rear]=item;
        this.rear=(this.rear + 1) % maxSize;
    }

    /**
     * 元素出队列操作
     */
    public int pop() {
//        判断当前队列是否已经为空
        if (isEmpty()) {
            System.out.println("队列已空");
            throw new QueueEmptyException("队列已空");
        }
        int result = this.queue[front];
        this.front = (this.front + 1) % maxSize;
        return result;
//
    }

    /**
     * 展示队列的全部内容
     */
    public void show() {
        // if (isEmpty()) {
        //     throw new RuntimeException("队列已空");
        // }
            System.out.println(Arrays.toString(this.queue));
    }
}
