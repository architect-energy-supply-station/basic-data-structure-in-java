package com.dynamic.bill4j.array.queue;

import java.util.Arrays;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/2/11
 */
public class ArrayCircleQueue2 {
    private int front;
    private int rear;
    private int size;
    private int[] queue;
    private int maxSize;

    public int getSize() {
        return size = (rear + maxSize - front) % maxSize;
    }

    public ArrayCircleQueue2(int maxSize) {
        front = 0;
        rear = 0;
        size = 0;
        maxSize = maxSize;
        queue = new int[maxSize];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {

        return (rear + 1) % maxSize == front;
    }

    public void push(int item) {
    //    是否队列已满
        if (isFull()) {
            throw new QueueFullException("队列已满！不能继续添加");
        }
        queue[rear] = item;
        rear = (rear + 1) % maxSize;
    }
    public int pop() {
        if (isEmpty()) {
            throw new QueueEmptyException("队列已空！");
        }
        int result = queue[front];
        front = (front + 1) % maxSize;
        return result;
    }

    public void show() {
        System.out.println(Arrays.toString(queue));
    }
}
