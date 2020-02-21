package com.dynamic.bill4j.link.foreignclassictextbook;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkList2Test {
    Link2 link1;
    Link2 link2;
    Link2 link3;
    Link2 link4;
    Link2 link5;
    LinkList2 linkList;

    @AfterEach
    void tearDown() {
        linkList = null;
    }

    @BeforeEach
    void setUp() {
        linkList = new LinkList2();
        link1 = new Link2(1, 1);
        link2 = new Link2(2, 2);
        link3 = new Link2(3, 3);
        link4 = new Link2(4, 4);
        link5 = new Link2(5, 5);
    }

    @Test
    void isEmpty() {
        assertTrue(linkList.isEmpty());
        linkList.insertFirst(1, 1);
        assertFalse(linkList.isEmpty());
        linkList.insertFirst(link1);
        assertFalse(linkList.isEmpty());
    }

    @Test
    void insertFirst() {
        linkList.insertFirst(link1);
        linkList.displayList();
        linkList.insertFirst(link2);
        linkList.insertFirst(link3);
        linkList.insertFirst(link4);
        linkList.insertFirst(link5);
        //这个是一个bug，不能插入重复的节点，会死循环
        // linkList.insertFirst(link5);
        linkList.displayList();
    }

    @Test
    void removeFirst() {
        System.out.println(linkList.removeFirst());
        linkList.displayList();
        linkList.insertFirst(link1);
        linkList.insertFirst(link2);
        linkList.insertFirst(link3);
        linkList.insertFirst(link4);
        linkList.insertFirst(link5);
        assertEquals(link5, linkList.removeFirst());
        assertEquals(link4, linkList.removeFirst());
        linkList.displayList();
    }

}