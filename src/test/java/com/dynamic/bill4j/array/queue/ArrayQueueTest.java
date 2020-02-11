package com.dynamic.bill4j.array.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {
    ArrayQueue2 arrayQueue;

    @Test
    void isEmpty() {
        arrayQueue = new ArrayQueue2(20);
        arrayQueue.show();
        assertTrue(arrayQueue.isEmpty());
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.show();
        assertFalse(arrayQueue.isEmpty());
    }

    @Test
    void isFull() {
        arrayQueue = new ArrayQueue2(5);
        arrayQueue.show();
        assertFalse(arrayQueue.isFull());
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        arrayQueue.push(22);
        arrayQueue.push(11);
        arrayQueue.show();
        assertTrue(arrayQueue.isFull());
    }

    @Test
    void push() {
        arrayQueue = new ArrayQueue2(5);
        arrayQueue.show();
        assertEquals(0, arrayQueue.getSize());
        //队列未满
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        arrayQueue.push(3);
        arrayQueue.push(22);
        arrayQueue.show();
        assertEquals(5, arrayQueue.getSize());
        //队列已满
        assertThrows(QueueFullException.class, () -> arrayQueue.push(22));

    }

    @Test
    void pop() {
        arrayQueue = new ArrayQueue2(5);
        arrayQueue.show();
        assertEquals(0, arrayQueue.getSize());
        //队列未满
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        arrayQueue.show();
        assertEquals(3, arrayQueue.getSize());
        arrayQueue.pop();
        arrayQueue.pop();
        arrayQueue.pop();
        arrayQueue.show();
        //队列已空
        assertEquals(0, arrayQueue.getSize());
    }
}