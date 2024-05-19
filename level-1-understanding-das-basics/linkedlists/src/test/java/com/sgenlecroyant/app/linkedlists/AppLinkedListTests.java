package com.sgenlecroyant.app.linkedlists;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppLinkedListTests {

    private AppLinkedList appLinkedList;

    @BeforeEach
    public void setUp() {
        this.appLinkedList = new AppLinkedList<>();
    }

    @Test
    void testAddAt() {
        this.appLinkedList.addAt(0, 10);
        this.appLinkedList.addAt(0, 20);

        assertThat(this.appLinkedList.getHead())
                .isEqualTo(20);
    }

    @Test
    void testAppend() {

        this.appLinkedList.addAt(0, 10);
        this.appLinkedList.addAt(0, 20);
        this.appLinkedList.append(40);

        assertThat(this.appLinkedList.getTail())
                .isEqualTo(40);
    }

    @Test
    void testGetHead() {

        this.appLinkedList.append(10);
        this.appLinkedList.append(20);
        this.appLinkedList.append(30);

        assertThat(appLinkedList.getHead())
                .isEqualTo(10);
    }

    @Test
    void testGetTail() {

        this.appLinkedList.append(10);
        this.appLinkedList.append(20);
        this.appLinkedList.append(30);

        assertThat(appLinkedList.getTail())
                .isEqualTo(30);
    }

    @Test
    void testPrepend() {

        this.appLinkedList.prepend(10);
        this.appLinkedList.prepend(20);
        this.appLinkedList.prepend(30);

        assertThat(this.appLinkedList.getHead())
                .isEqualTo(30);
    }

    @Test
    void testRemoveAt() {

        this.appLinkedList.append(10);
        this.appLinkedList.append(20);
        this.appLinkedList.append(30);

        this.appLinkedList.removeAt(0);
        assertThat(this.appLinkedList.getHead())
                .isEqualTo(20);
    }

    @Test
    void testRemoveFirst() {
        this.appLinkedList.append(10);
        this.appLinkedList.append(20);
        this.appLinkedList.append(30);

        this.appLinkedList.removeFirst();
        assertThat(this.appLinkedList.getHead())
                .isEqualTo(20);
    }

    @Test
    void testRemoveLast() {

        this.appLinkedList.append(10);
        this.appLinkedList.append(20);
        this.appLinkedList.append(30);

        this.appLinkedList.removeLast();
        this.appLinkedList.print();
        assertThat(this.appLinkedList.getTail())
                .isEqualTo(20);
    }
}
