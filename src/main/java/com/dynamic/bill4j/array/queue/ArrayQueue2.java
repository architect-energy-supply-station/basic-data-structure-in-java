package com.dynamic.bill4j.array.queue;

import java.util.Arrays;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/2/11
 */
public class ArrayQueue2 {
    private int front;
    private int rear;
    private int size;
    private int[] queue;
    private int maxSize;

    public int getSize() {
        return size = this.rear - this.front;
    }

    public ArrayQueue2(int maxSize) {
        this.front = front-1;
        this.rear = rear-1;
        this.size = 0;
        this.maxSize = maxSize;
        this.queue = new int[maxSize];
    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public boolean isFull() {
        return this.rear == this.maxSize - 1;
    }

    public void push(int item) {
    //    是否队列已满
        if (isFull()) {
            throw new QueueFullException("队列已满！不能继续添加");
        }
        this.rear++;
        this.queue[rear] = item;
    }
    public int pop() {
        if (isEmpty()) {
            throw new QueueEmptyException("队列已空！");
        }
        this.front++;
        return this.queue[front];
    }

    public void show() {
        System.out.println(Arrays.toString(this.queue));
    }
}
