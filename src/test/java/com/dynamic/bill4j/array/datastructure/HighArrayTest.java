package com.dynamic.bill4j.array.datastructure;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HighArrayTest {
    HighArray array ;
    @BeforeEach
    void setUp() {
        array = new HighArray(20);
        array.insert(2);
        array.insert(12);
        array.insert(22);
        array.insert(5);
        array.insert(8);
        array.insert(23);
        array.insert(25);
        array.insert(28);
        array.insert(21);
        array.insert(99);
        System.out.println("打印初始化数组内容");
        array.display();
    }

    @AfterEach
    void tearDown() {
        array = null;
    }

    @Test
    void getMax() {
        assertEquals(99, array.getMax());
    }

    @Test
    void getMin() {
        assertEquals(2, array.getMin());
    }

    @Test
    void removeMax() {
        assertEquals(99, array.removeMax(), "实际值");
        assertEquals(22, array.removeMax(), "实际值不符合");
    }

    @Test
    void insert() {
        array.insert(88);
        assertEquals(11, array.geteElement());
    }

    @Test
    void delete() {
        assertTrue(array.delete(22));
        assertFalse(array.delete(-1));
    }


    @Test
    void find() {
        assertEquals(2, array.find(22), "没有啥");
        assertEquals(-1, array.find(-1), "没有啥");
    }

}