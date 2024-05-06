package com.sgenlecroyant.app.arrays;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class AppArray<T> {

    private T[] data;
    private int count;
    private static int DEFAULT_SIZE = 10;

    public AppArray() {
        this.data = (T[]) new Object[DEFAULT_SIZE];
    }

    public AppArray(int initialSize) {
        this.data = (T[]) new Object[initialSize];
    }

    public void add(T value) {

        if (this.count >= this.data.length) {
            T[] newArray = (T[]) new Object[this.count * 2];
            for (int i = 0; i < this.count; i++) {
                newArray[i] = this.data[i];
            }
            this.data = newArray;
        }
        this.data[this.count++] = value;
    }

    public void resize() {

        T[] newArray = (T[]) new Object[this.count * 2];
        for (int i = 0; i < this.count; i++) {
            newArray[i] = this.data[i];
        }
        this.data = newArray;
    }

    public void print() {
        for (int i = 0; i < this.count; i++) {
            System.out.println(this.data[i]);
        }
    }

    public void addFirst(T value) {
        for (int i = this.count - 1; i > 0; i--) {
            this.data[i] = this.data[i + 1];
        }
        print();
    }

    public void addAt(int index, T value) {
        if (index < 0 || index >= this.data.length) {
            throw new ArrayIndexOutOfBoundsException("Invalid index:" + index);
        }

        System.out.println("count:" + this.count + " and item: " + this.data[this.count]);
        this.print();
        if (this.count >= this.data.length) {
            T[] newArray = (T[]) new Object[this.count * 2];
        for (int i = 0; i < this.count; i++) {
            newArray[i] = this.data[i];
        }
        this.data = newArray;
        }

        for (int i = this.count; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[index] = value;
        this.count++;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= this.count) {
            throw new RuntimeException("Invalid index");
        }

        T[] newArray = (T[])new Object[this.count+1];

        for(int i = index; i < this.count; i++){
            newArray[i+1] = this.data[i];
        }
        this.data = newArray;
        this.count--;
    }

}