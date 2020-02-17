package com.dynamic.bill4j.link.bilibli.single;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}