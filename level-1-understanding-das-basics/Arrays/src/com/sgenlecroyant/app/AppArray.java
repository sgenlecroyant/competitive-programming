package com.sgenlecroyant.app;

/**
 * An abstract data type to implement how arrays work behind the curtains
 *
 * @param <T> a generic type to make it suitable to store any data type that exists
 */
@SuppressWarnings("unchecked")
public class AppArray<T> {
    private T[] data;
    private int count = 0;
    private static final int DEFAULT_SIZE = 10;

    public AppArray(int initialSize) {
        // we must cast this back to T[] after we instantiated this as an array of Object since up until here we don't know what type T really is
        this.data = (T[]) new Object[initialSize];
    }

    public AppArray() {
        this.data = (T[]) new Object[DEFAULT_SIZE];
    }

    public void add(T value) {
        if (this.count >= this.data.length) {
            T[] newArray = (T[]) new Object[this.count + (this.count / 2)];

            for (int i = 0; i < this.count; i++) {
                newArray[i] = this.data[i];
            }
            this.data = newArray;
        }
        this.data[this.count++] = value;
    }

    public void doPrint() {
        /**
         * here we loop up until this.count and not this.data.length since indices from this.count have null
         * values in this.data[index]
         */
        System.out.println("====PRINT ARRAY===");
        for (int i = 0; i < this.count; i++){
            System.out.println(this.data[i]);
        }
    }
}
