package com.sgenlecroyant.app.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class AppArrayTest {

    private AppArray<Integer> appArray;

    @BeforeEach
    void setUp() {
        this.appArray = new AppArray<>(2);
    }

    @Test
    void shouldAddItem() {
        this.appArray.add(1);
        this.appArray.add(2);


        Assertions.assertThat(this.appArray.getSize())
                .isEqualTo(2);
    }

    @Test
    public void shouldResizeArrayAndAddItem() {
        int currentSize = this.appArray.getSize();
        this.appArray.add(10);
        this.appArray.add(20);
        this.appArray.add(30);
        this.appArray.add(40);

        Assertions.assertThat(currentSize).isLessThan(this.appArray.getSize());

    }

    @Test
    void shouldReturnNegativeIndexOfFirstItemOccurrence() {
        this.appArray.add(10);

        Assertions.assertThat(this.appArray.indexOf(20))
                .isNegative();
    }

    @Test
    void shouldReturnIndexOfFirstItemOccurrence() {
        this.appArray.add(10);

        Assertions.assertThat(this.appArray.indexOf(10))
                .isEqualTo(0);
    }

    @Test
    void shouldContainItemX() {
        this.appArray.add(10);
        this.appArray.add(20);

        Assertions.assertThat(this.appArray.contains(10)).isTrue();
    }

    @Test
    void shouldNotContainItemX() {
        this.appArray.add(10);
        this.appArray.add(20);

        Assertions.assertThat(this.appArray.contains(100)).isFalse();
    }

    @Test
    void shouldAddFirst() {
        int value = 10;
        this.appArray.addFirst(value);
        Integer firstItem = this.appArray.getFirst();
        Assertions.assertThat(firstItem).isEqualTo(value);
    }

}