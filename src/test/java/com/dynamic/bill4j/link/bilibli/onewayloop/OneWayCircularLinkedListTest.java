package com.dynamic.bill4j.link.bilibli.onewayloop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OneWayCircularLinkedListTest {
    OneWayCircularLinkedList oneWayCircularLinkedList;

    @BeforeEach
    void setUp() {
        oneWayCircularLinkedList = new OneWayCircularLinkedList();
    }

    @AfterEach
    void tearDown() {
        oneWayCircularLinkedList = null;
    }

    @Test
    void add() {
        oneWayCircularLinkedList.display();
        oneWayCircularLinkedList.add(5);
        oneWayCircularLinkedList.display();
    }

    @Test
    void josephProblem() {
        oneWayCircularLinkedList.add(5);
        oneWayCircularLinkedList.display();
        oneWayCircularLinkedList.josephProblem(1, 2,5);
    }
}