package com.dynamic.bill4j.link.bilibli.single;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SingleLinkedListTest {
    SingleLinkedList singleLinkedList;
    HeroNode node1;
    HeroNode node2;
    HeroNode node3;
    HeroNode node4;

    @BeforeEach
    void setUp() {
        singleLinkedList = new SingleLinkedList();
        node1 = new HeroNode(1, "bill", "bb");
        node2 = new HeroNode(2, "cindy", "cc");
        node3 = new HeroNode(3, "angle", "aa");
        node4 = new HeroNode(4, "alice", "yu");
    }


    @Test
    void add() {
        assertEquals(0, singleLinkedList.getCount());

        singleLinkedList.add(node1);
        singleLinkedList.display();
        assertEquals(1, singleLinkedList.getCount());
        singleLinkedList.add(node2);
        assertEquals(2, singleLinkedList.getCount());
        singleLinkedList.add(node3);
        assertEquals(3, singleLinkedList.getCount());
        singleLinkedList.add(node4);
        assertEquals(4, singleLinkedList.getCount());
        singleLinkedList.display();
    }
    @Test
    void addToFirstNodeAlways() throws CloneNotSupportedException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        assertEquals(0, singleLinkedList.getCount());

        singleLinkedList.addToFirstNodeAlways(node1);
        singleLinkedList.display();
        assertEquals(1, singleLinkedList.getCount());
        singleLinkedList.addToFirstNodeAlways(node2);
        assertEquals(2, singleLinkedList.getCount());
        singleLinkedList.addToFirstNodeAlways(node3);
        assertEquals(3, singleLinkedList.getCount());
        singleLinkedList.addToFirstNodeAlways(node4);
        assertEquals(4, singleLinkedList.getCount());
        singleLinkedList.display();
    }
    @Test
    void addToFirstNodeAlwaysStatic()  {
        assertEquals(0, singleLinkedList.getCount());

        SingleLinkedList.addToFirstNodeAlways(singleLinkedList,node1);
        SingleLinkedList.addToFirstNodeAlways(singleLinkedList,node2);
        SingleLinkedList.addToFirstNodeAlways(singleLinkedList,node3);
        SingleLinkedList.addToFirstNodeAlways(singleLinkedList,node4);
        singleLinkedList.display();
    }

    @Test
    void addInOrder() {
        assertEquals(0, singleLinkedList.getCount());
        singleLinkedList.display();
        singleLinkedList.addInOrder(node2);
        assertEquals(1, singleLinkedList.getCount());
        singleLinkedList.addInOrder(node1);
        assertEquals(2, singleLinkedList.getCount());
        singleLinkedList.addInOrder(node4);
        assertEquals(3, singleLinkedList.getCount());
        singleLinkedList.addInOrder(node3);
        assertEquals(4, singleLinkedList.getCount());
        singleLinkedList.display();
    }
    @Test
    void revertSingleLinkedList() {
        assertEquals(0, singleLinkedList.getCount());
        singleLinkedList.display();
        singleLinkedList.addInOrder(node2);
        assertEquals(1, singleLinkedList.getCount());
        singleLinkedList.addInOrder(node1);
        assertEquals(2, singleLinkedList.getCount());
        singleLinkedList.addInOrder(node4);
        assertEquals(3, singleLinkedList.getCount());
        singleLinkedList.addInOrder(node3);
        assertEquals(4, singleLinkedList.getCount());
        singleLinkedList.display();
        System.out.println("转制前*************");
        SingleLinkedList.revertSingleLinkedList(singleLinkedList);
        singleLinkedList.display();
    }
    @Test
    void revertSingleLinkedListByStack() {
        assertEquals(0, singleLinkedList.getCount());
        singleLinkedList.display();
        singleLinkedList.addInOrder(node2);
        assertEquals(1, singleLinkedList.getCount());
        singleLinkedList.addInOrder(node1);
        assertEquals(2, singleLinkedList.getCount());
        singleLinkedList.addInOrder(node4);
        assertEquals(3, singleLinkedList.getCount());
        singleLinkedList.addInOrder(node3);
        assertEquals(4, singleLinkedList.getCount());
        singleLinkedList.display();
        System.out.println("转制前*************");
        SingleLinkedList.reverse(singleLinkedList);
        singleLinkedList.display();
    }

    @Test
    void remove() {
        assertEquals(0, singleLinkedList.getCount());
        singleLinkedList.display();
        singleLinkedList.addInOrder(node2);
        assertEquals(1, singleLinkedList.getCount());
        singleLinkedList.addInOrder(node1);
        assertEquals(2, singleLinkedList.getCount());
        singleLinkedList.addInOrder(node4);
        assertEquals(3, singleLinkedList.getCount());
        singleLinkedList.addInOrder(node3);
        assertEquals(4, singleLinkedList.getCount());
        singleLinkedList.display();

        singleLinkedList.remove(2);
        assertEquals(3, singleLinkedList.getCount());
        singleLinkedList.display();
        singleLinkedList.remove(4);
        assertEquals(2, singleLinkedList.getCount());
        singleLinkedList.display();
        singleLinkedList.remove(1);
        assertEquals(1, singleLinkedList.getCount());
        singleLinkedList.display();
        singleLinkedList.remove(1);
        assertEquals(1, singleLinkedList.getCount());
        singleLinkedList.display();
    }

    @Test
    void update() {
        assertEquals(0, singleLinkedList.getCount());
        singleLinkedList.display();
        singleLinkedList.addInOrder(node2);
        assertEquals(1, singleLinkedList.getCount());
        singleLinkedList.addInOrder(node1);
        assertEquals(2, singleLinkedList.getCount());
        singleLinkedList.addInOrder(node4);
        assertEquals(3, singleLinkedList.getCount());
        singleLinkedList.addInOrder(node3);
        assertEquals(4, singleLinkedList.getCount());
        singleLinkedList.display();

        HeroNode updateNode = new HeroNode(2, "updated", "updated ~~");
        singleLinkedList.update(updateNode);
        singleLinkedList.display();

        HeroNode updateNode2 = new HeroNode(5, "updated", "updated ~~");
        singleLinkedList.update(updateNode2);
        singleLinkedList.display();

    }

    @Test
    void getLength() {
        assertEquals(0, singleLinkedList.getCount());
        singleLinkedList.display();
        singleLinkedList.addInOrder(node2);
        assertEquals(1, singleLinkedList.getCount());
        singleLinkedList.addInOrder(node1);
        assertEquals(2, singleLinkedList.getCount());
        singleLinkedList.addInOrder(node4);
        assertEquals(3, singleLinkedList.getCount());
        assertEquals(singleLinkedList.getCount(), singleLinkedList.getLength(singleLinkedList.getHead()));
        singleLinkedList.addInOrder(node3);
        assertEquals(4, singleLinkedList.getCount());
        singleLinkedList.display();

        assertEquals(singleLinkedList.getCount(), singleLinkedList.getLength(singleLinkedList.getHead()));
    }
    @Test
    void nodeOfLastIndex() {
        assertEquals(0, singleLinkedList.getCount());
        singleLinkedList.display();
        singleLinkedList.addInOrder(node2);
        assertEquals(1, singleLinkedList.getCount());
        singleLinkedList.addInOrder(node1);
        assertEquals(2, singleLinkedList.getCount());
        singleLinkedList.addInOrder(node4);
        assertEquals(3, singleLinkedList.getCount());
        assertEquals(singleLinkedList.getCount(), singleLinkedList.getLength(singleLinkedList.getHead()));
        singleLinkedList.addInOrder(node3);
        assertEquals(4, singleLinkedList.getCount());
        singleLinkedList.display();

        assertEquals(singleLinkedList.getCount(), singleLinkedList.getLength(singleLinkedList.getHead()));
        assertEquals(node4, singleLinkedList.nodeOfLastIndex(singleLinkedList.getHead(), 0));
        assertEquals(node3, singleLinkedList.nodeOfLastIndex(singleLinkedList.getHead(), 1));
        assertEquals(node2, singleLinkedList.nodeOfLastIndex(singleLinkedList.getHead(), 2));
        assertEquals(node1, singleLinkedList.nodeOfLastIndex(singleLinkedList.getHead(), 3));
    }@Test
    void nodeOfLastIndex2() {
        assertEquals(0, singleLinkedList.getCount());
        singleLinkedList.display();
        singleLinkedList.addInOrder(node2);
        assertEquals(1, singleLinkedList.getCount());
        singleLinkedList.addInOrder(node1);
        assertEquals(2, singleLinkedList.getCount());
        singleLinkedList.addInOrder(node4);
        assertEquals(3, singleLinkedList.getCount());
        assertEquals(singleLinkedList.getCount(), singleLinkedList.getLength(singleLinkedList.getHead()));
        singleLinkedList.addInOrder(node3);
        assertEquals(4, singleLinkedList.getCount());
        singleLinkedList.display();

        assertEquals(singleLinkedList.getCount(), singleLinkedList.getLength(singleLinkedList.getHead()));
        assertEquals(node4, singleLinkedList.nodeOfLastIndexOf2(singleLinkedList.getHead(), 0));
        assertEquals(node3, singleLinkedList.nodeOfLastIndexOf2(
                singleLinkedList.getHead(), 1));
        assertEquals(node2, singleLinkedList.nodeOfLastIndexOf2(
                singleLinkedList.getHead(), 2));
        assertEquals(node1, singleLinkedList.nodeOfLastIndexOf2(
                singleLinkedList.getHead(), 3));
    }


}