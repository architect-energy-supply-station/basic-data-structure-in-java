package com.dynamic.bill4j.link.bilibli.single;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SingleLinkedList2Test {
SingleLinkedList2 singleLinkedList;
    HeroNode2 node1;
    HeroNode2 node2;
    HeroNode2 node3;
    HeroNode2 node4;
    @BeforeEach
    void setUp() {
        singleLinkedList = new SingleLinkedList2();
         node1 = new HeroNode2(1, "bill", "bb");
         node2 = new HeroNode2(2, "cindy", "cc");
         node3 = new HeroNode2(3, "angle", "aa");
         node4 = new HeroNode2(4, "alice", "yu");
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
}