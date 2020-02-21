package com.dynamic.bill4j.link.foreignclassictextbook;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkListTest {
    Link link1;
    Link link2;
    Link link3;
    Link link4;
    Link link5;
    LinkList linkList;

    @AfterEach
    void tearDown() {
        linkList = null;
    }

    @BeforeEach
    void setUp() {
        linkList = new LinkList();
        link1 = new Link(1, 1);
        link2 = new Link(2, 2);
        link3 = new Link(3, 3);
        link4 = new Link(4, 4);
        link5 = new Link(5, 5);
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