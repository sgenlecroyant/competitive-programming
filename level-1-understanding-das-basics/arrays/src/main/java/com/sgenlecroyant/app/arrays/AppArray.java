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

    public int add(T value) {

        if (this.count >= this.data.length) {
            resize();
        }
        this.data[this.count++] = value;
        return count;
    }

    public void resize() {

        T[] newArray = (T[]) new Object[this.count * 2];
        for (int i = 0; i < this.count; i++) {
            newArray[i] = this.data[i];
        }
        this.data = newArray;
    }

    public void print(){
        for (int i = 0; i < this.count; i++) {
            System.out.println(this.data[i]);
        }
    }

    public void addFirst(T value){
        for(int i = this.count - 1; i > 0; i--){
            this.data[i] = this.data[i+1];
        }
        print();
    }

    public void addAt(int index){
        if (index < 0 || index >= this.data.length) {
            throw new ArrayIndexOutOfBoundsException("Invalid index:" +index);
        }

        for(int i = index; i < this.count - 1; i++){
            System.out.println(this.data[i]+ " => " +this.data[i+1]);
        }
    }

    public void removeAt(int index){
        if (index < 0 || index >= this.count) {
            throw new RuntimeException("Invalid index");
        }

        // for(int i = this.count)
    }

}