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
public class ArrayQueue {

    private int front;
    private int rear;
    private int maxSize;

    private int[] Queue;

    public ArrayQueue( int maxSize) {
        this.front = front-1;
        this.rear = rear-1;
        this.maxSize = maxSize;
        this.Queue = new int[maxSize];
    }

    /**
     * 首位相接时，表示队列已空。可能均为-1，也可能均为非负值
     * @return true表示空，false表示非空
     */
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    /**
     * 尾部指针等于最大值的时候，表示队列已满
     * @return true 表示队列满，false表示未满
     */
    public boolean isFull() {
        return this.rear == this.maxSize -1;
    }

    /**
     * 往队列添加元素，入队列操作
     * @param item 需要添加的元素
     */
    public void push(int item) {
//       需要检查元素的合法性，入参校验：这里使用最简单的校验方式，抛出illegalArgumentsExceptions。作为demo，暂不做
//        判断队列是否满
        if (this.isFull()) {
            System.out.println("队列已满！无法继续添加");
            return;
        }

        rear++;
        this.Queue[rear]=item;
    }

    /**
     * 元素出队列操作
     */
    public int pop() {
//        判断当前队列是否已经为空
        if (isEmpty()) {
            System.out.println("队列已空");
            throw new RuntimeException("当前队列已空！");
        }
        front++;
        return this.Queue[front];
//
    }

    /**
     * 展示队列的全部内容
     */
    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空");
        }
            System.out.println(Arrays.toString(this.Queue));
    }
}
