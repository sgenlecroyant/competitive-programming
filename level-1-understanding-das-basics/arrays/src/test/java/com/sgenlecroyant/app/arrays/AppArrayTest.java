package com.sgenlecroyant.app.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void shouldResizeArrayAndAddItem(){
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
}