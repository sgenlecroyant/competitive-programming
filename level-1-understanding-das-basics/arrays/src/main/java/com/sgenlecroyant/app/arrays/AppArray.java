package com.sgenlecroyant.app.arrays;

import java.util.Arrays;

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
            resizeArray();
        }
        this.data[this.count++] = value;
    }

    private void resizeArray() {
        T[] newArray = (T[]) new Object[this.count + (this.count / 2)];

        for (int i = 0; i < this.count; i++) {
            newArray[i] = this.data[i];
        }
        this.data = newArray;
    }

    public void doPrint() {
        /**
         * here we loop up until this.count and not this.data.length since indices from this.count have null
         * values in this.data[index]
         */
        System.out.println("====PRINT ARRAY===");
        for (int i = 0; i < this.count; i++) {
            System.out.println(this.data[i]+ " at index: " +i);
        }
    }

    public int indexOf(T value) {
        for (int i = 0; i < this.count; i++) {
            if (this.data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public int getSize() {
        return this.count;
    }

    public boolean contains(T value) {
        return this.indexOf(value) >= 0;
    }

    public boolean addFirst(T value) {

        if (this.count <= 0) {
            this.data[this.count++] = value;
            return true;
        }
        this.addAt(0, value);
        return true;
    }

    public void addAt(int index, T value) {
        if (this.count >= this.data.length){
            this.resizeArray();
        }
        for(int i = this.count; i > index; i--){
            this.data[i] = this.data[i-1];
        }
        this.data[index] = value;
        this.count++;
    }

    public void addLast(T value){
        this.addAt(this.count,value);
    }

    public int getLength() {
        return this.data.length;
    }

    public void removeAt(int index){
        if (index < 0 || index >= this.count){
            throw new RuntimeException("Index Out of bounds: " +index);
        }

        for (int i = index; i < this.count; i++){
            this.data[i] = this.data[i+1];
        }
        this.count--;
        System.out.println("==done removing===");
    }

    public T[] getArray() {
        return this.data;
    }

    public T getFirst() {
        if (this.count <= 0){
            throw new RuntimeException("Array is empty");
        }
        return this.data[0];
    }
}