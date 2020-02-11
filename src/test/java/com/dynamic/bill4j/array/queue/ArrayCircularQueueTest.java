package com.dynamic.bill4j.array.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayCircularQueueTest {
    ArrayCircularQueue arrayQueue;

    @Test
    void isEmpty() {
        arrayQueue = new ArrayCircularQueue(4);
        arrayQueue.show();
        assertTrue(arrayQueue.isEmpty());
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.show();
        assertFalse(arrayQueue.isEmpty());
    }

    @Test
    void isFull() {
        arrayQueue = new ArrayCircularQueue(4);
        arrayQueue.show();
        assertFalse(arrayQueue.isFull());
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        arrayQueue.show();
        assertThrows(QueueFullException.class, ()->arrayQueue.push(22));
        assertTrue(arrayQueue.isFull());
    }

    @Test
    void push() {
        arrayQueue = new ArrayCircularQueue(5);
        arrayQueue.show();
        assertEquals(0, arrayQueue.getSize());
        //队列未满
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        arrayQueue.push(3);
        arrayQueue.show();
        assertEquals(4, arrayQueue.getSize());
        //队列已满
        assertThrows(QueueFullException.class, () -> arrayQueue.push(22));

    }

    @Test
    void pop() {
        arrayQueue = new ArrayCircularQueue(4);
        arrayQueue.show();
        assertEquals(0, arrayQueue.getSize());
        //队列未满
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        arrayQueue.show();
        assertEquals(3, arrayQueue.getSize());
        System.out.println(arrayQueue.pop());
        System.out.println(arrayQueue.pop());
        System.out.println(arrayQueue.pop());
        assertThrows(QueueEmptyException.class, () -> arrayQueue.pop());
        //队列已空
        assertEquals(0, arrayQueue.getSize());
        arrayQueue.push(3);
        arrayQueue.push(2);
        arrayQueue.push(1);
        arrayQueue.show();
        assertEquals(3, arrayQueue.getSize());
        assertThrows(QueueFullException.class, () -> arrayQueue.push(1));
        System.out.println(arrayQueue.pop());
        System.out.println(arrayQueue.pop());
        System.out.println(arrayQueue.pop());
        assertEquals(0, arrayQueue.getSize());

        assertThrows(QueueEmptyException.class, () -> arrayQueue.pop());
        arrayQueue.push(11);
        arrayQueue.push(22);
        arrayQueue.push(33);
        arrayQueue.show();
    }

}