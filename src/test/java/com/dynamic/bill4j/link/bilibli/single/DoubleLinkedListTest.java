package com.dynamic.bill4j.link.bilibli.single;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DoubleLinkedListTest {
    DoubleLinkedList doubleLinkedList;
    DoubleHeroNode node1;
    DoubleHeroNode node2;
    DoubleHeroNode node3;
    DoubleHeroNode node4;

    @BeforeEach
    void setUp() {
        doubleLinkedList = new DoubleLinkedList();
        node1 = new DoubleHeroNode(1, "bill", "bb");
        node2 = new DoubleHeroNode(2, "cindy", "cc");
        node3 = new DoubleHeroNode(3, "angle", "aa");
        node4 = new DoubleHeroNode(4, "alice", "yu");
    }


    @Test
    void add() {
        assertEquals(0, doubleLinkedList.getCount());

        doubleLinkedList.add(node1);
        doubleLinkedList.display();
        assertEquals(1, doubleLinkedList.getCount());
        doubleLinkedList.add(node2);
        assertEquals(2, doubleLinkedList.getCount());
        doubleLinkedList.add(node3);
        assertEquals(3, doubleLinkedList.getCount());
        doubleLinkedList.add(node4);
        assertEquals(4, doubleLinkedList.getCount());
        doubleLinkedList.display();
    }
    @Test
    void addToFirstNodeAlways() throws CloneNotSupportedException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        assertEquals(0, doubleLinkedList.getCount());

        doubleLinkedList.addToFirstNodeAlways(node1);
        doubleLinkedList.display();
        assertEquals(1, doubleLinkedList.getCount());
        doubleLinkedList.addToFirstNodeAlways(node2);
        assertEquals(2, doubleLinkedList.getCount());
        doubleLinkedList.addToFirstNodeAlways(node3);
        assertEquals(3, doubleLinkedList.getCount());
        doubleLinkedList.addToFirstNodeAlways(node4);
        assertEquals(4, doubleLinkedList.getCount());
        doubleLinkedList.display();
    }

    @Test
    void addInOrder() {
        assertEquals(0, doubleLinkedList.getCount());
        doubleLinkedList.display();
        doubleLinkedList.addInOrder(node2);
        assertEquals(1, doubleLinkedList.getCount());
        doubleLinkedList.addInOrder(node1);
        assertEquals(2, doubleLinkedList.getCount());
        doubleLinkedList.addInOrder(node4);
        assertEquals(3, doubleLinkedList.getCount());
        doubleLinkedList.addInOrder(node3);
        assertEquals(4, doubleLinkedList.getCount());
        doubleLinkedList.display();
    }

    @Test
    void remove() {
        assertEquals(0, doubleLinkedList.getCount());
        doubleLinkedList.display();
        doubleLinkedList.addToFirstNodeAlways(node2);
        assertEquals(1, doubleLinkedList.getCount());
        doubleLinkedList.addToFirstNodeAlways(node1);
        assertEquals(2, doubleLinkedList.getCount());
        doubleLinkedList.addToFirstNodeAlways(node4);
        assertEquals(3, doubleLinkedList.getCount());
        doubleLinkedList.addToFirstNodeAlways(node3);
        assertEquals(4, doubleLinkedList.getCount());
        doubleLinkedList.display();

        doubleLinkedList.remove(2);
        assertEquals(3, doubleLinkedList.getCount());
        doubleLinkedList.display();
        doubleLinkedList.remove(4);
        assertEquals(2, doubleLinkedList.getCount());
        doubleLinkedList.display();
        doubleLinkedList.remove(3);
        doubleLinkedList.display();
        // singleLinkedList.remove(1);
        // assertEquals(1, singleLinkedList.getCount());
        // singleLinkedList.display();
        // singleLinkedList.remove(1);
        // assertEquals(1, singleLinkedList.getCount());
        // singleLinkedList.display();
    }

    @Test
    void update() {
        assertEquals(0, doubleLinkedList.getCount());
        doubleLinkedList.display();
        doubleLinkedList.addInOrder(node2);
        assertEquals(1, doubleLinkedList.getCount());
        doubleLinkedList.addInOrder(node1);
        assertEquals(2, doubleLinkedList.getCount());
        doubleLinkedList.addInOrder(node4);
        assertEquals(3, doubleLinkedList.getCount());
        doubleLinkedList.addInOrder(node3);
        assertEquals(4, doubleLinkedList.getCount());
        doubleLinkedList.display();

        DoubleHeroNode updateNode = new DoubleHeroNode(2, "updated", "updated ~~");
        doubleLinkedList.update(updateNode);
        doubleLinkedList.display();

        DoubleHeroNode updateNode2 = new DoubleHeroNode(5, "updated", "updated ~~");
        doubleLinkedList.update(updateNode2);
        doubleLinkedList.display();

    }

    @Test
    void getLength() {
        assertEquals(0, doubleLinkedList.getCount());
        doubleLinkedList.display();
        doubleLinkedList.addInOrder(node2);
        assertEquals(1, doubleLinkedList.getCount());
        doubleLinkedList.addInOrder(node1);
        assertEquals(2, doubleLinkedList.getCount());
        doubleLinkedList.addInOrder(node4);
        assertEquals(3, doubleLinkedList.getCount());
        assertEquals(doubleLinkedList.getCount(), doubleLinkedList.getLength(doubleLinkedList.getHead()));
        doubleLinkedList.addInOrder(node3);
        assertEquals(4, doubleLinkedList.getCount());
        doubleLinkedList.display();

        assertEquals(doubleLinkedList.getCount(), doubleLinkedList.getLength(doubleLinkedList.getHead()));
    }
    @Test
    void nodeOfLastIndex() {
        assertEquals(0, doubleLinkedList.getCount());
        doubleLinkedList.display();
        doubleLinkedList.addInOrder(node2);
        assertEquals(1, doubleLinkedList.getCount());
        doubleLinkedList.addInOrder(node1);
        assertEquals(2, doubleLinkedList.getCount());
        doubleLinkedList.addInOrder(node4);
        assertEquals(3, doubleLinkedList.getCount());
        assertEquals(doubleLinkedList.getCount(), doubleLinkedList.getLength(doubleLinkedList.getHead()));
        doubleLinkedList.addInOrder(node3);
        assertEquals(4, doubleLinkedList.getCount());
        doubleLinkedList.display();

        assertEquals(doubleLinkedList.getCount(), doubleLinkedList.getLength(doubleLinkedList.getHead()));
        assertEquals(node4, doubleLinkedList.nodeOfLastIndex(doubleLinkedList.getHead(), 0));
        assertEquals(node3, doubleLinkedList.nodeOfLastIndex(doubleLinkedList.getHead(), 1));
        assertEquals(node2, doubleLinkedList.nodeOfLastIndex(doubleLinkedList.getHead(), 2));
        assertEquals(node1, doubleLinkedList.nodeOfLastIndex(doubleLinkedList.getHead(), 3));
    }@Test
    void nodeOfLastIndex2() {
        assertEquals(0, doubleLinkedList.getCount());
        doubleLinkedList.display();
        doubleLinkedList.addInOrder(node2);
        assertEquals(1, doubleLinkedList.getCount());
        doubleLinkedList.addInOrder(node1);
        assertEquals(2, doubleLinkedList.getCount());
        doubleLinkedList.addInOrder(node4);
        assertEquals(3, doubleLinkedList.getCount());
        assertEquals(doubleLinkedList.getCount(), doubleLinkedList.getLength(doubleLinkedList.getHead()));
        doubleLinkedList.addInOrder(node3);
        assertEquals(4, doubleLinkedList.getCount());
        doubleLinkedList.display();

        assertEquals(doubleLinkedList.getCount(), doubleLinkedList.getLength(doubleLinkedList.getHead()));
    }


}