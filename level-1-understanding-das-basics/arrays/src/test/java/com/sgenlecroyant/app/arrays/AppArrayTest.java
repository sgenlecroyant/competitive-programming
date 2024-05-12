package com.sgenlecroyant.app.arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppArrayTest {

    private AppArray<Integer> appArray;

    @BeforeEach
    public void setUp() {
        this.appArray = new AppArray<>();
    }

    @Test
    public void shouldAddItem() {

        int value = 10;
        this.appArray.add(value);
        assertThat(value).isEqualTo(this.appArray.getFirst());
    }

    @Test
    public void shouldAddFirst() {

        int value = 10;
        this.appArray.add(12);
        this.appArray.add(15);
        this.appArray.addFirst(value);
        assertThat(this.appArray.getFirst()).isEqualTo(value);
    }

    @Test
    public void shouldAddLast() {

        int value = 1000;
        this.appArray.add(10);
        this.appArray.add(11);
        this.appArray.add(12);
        this.appArray.addLast(value);

        assertThat(this.appArray.getLast()).isEqualTo(value);
    }

    @Test
    public void shouldRemoveAtIndex() {
        int firstValue = 10;
        this.appArray.add(firstValue);
        this.appArray.add(11);
        this.appArray.add(12);

        this.appArray.removeAt(0);

        assertThat(appArray.indexOf(firstValue))
                .isNegative();
        assertThat(appArray.getFirst()).isNotEqualTo(firstValue)
                .isEqualTo(11);

    }

    @Test
    public void shouldThrowExceptionWhenPassingInvalidIndex() {
        this.appArray.add(10);

        assertThatThrownBy(() -> this.appArray.get(1000))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void shouldRemoveFirst() {
        int firstValue = 10;
        this.appArray.add(firstValue);
        appArray.add(12);
        appArray.add(13);

        appArray.removeFirst();
        assertThat(appArray.indexOf(firstValue))
                .isNegative();
    }

    @Test
    public void shouldRemoveLast() {
        int lastValue = 13;
        appArray.add(10);
        appArray.add(11);
        this.appArray.add(lastValue);

        this.appArray.removeLast();
        assertThat(appArray.indexOf(lastValue))
                .isNegative();
    }
}