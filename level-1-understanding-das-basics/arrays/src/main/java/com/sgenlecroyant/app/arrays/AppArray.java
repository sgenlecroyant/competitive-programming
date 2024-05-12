package com.sgenlecroyant.app.arrays;

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

    public void print() {
        System.out.println("=====printing=====");
        System.out.printf("count: %d, size: %d\n",this.count, this.data.length);
        for (int i = 0; i < this.count; i++) {
            System.out.println(this.data[i]);
        }
    }

    public void resizeArray() {
        T[] resizedArray = (T[]) new Object[this.count * 2];

        for (int i = 0; i < this.count; i++) {
            resizedArray[i] = this.data[i];
        }
        this.data = resizedArray;
    }

    public int add(T value) {
        if (this.count >= this.data.length) {
            resizeArray();
        }
        this.data[this.count++] = value;
        return this.count - 1;
    }

    public boolean addAt(int index, T value) {

        if (index > count || index < 0) {
            throw new RuntimeException("Invalid Index target: " + index);
        }
        if (this.count >= this.data.length) {
            resizeArray();
        }

        for (int i = this.count; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }

        this.data[index] = value;
        this.count++;
        return true;
    }

    public boolean addFirst(T value) {
        this.addAt(0, value);
        return true;
    }

    public boolean addLast(T value) {
        this.addAt(this.count, value);
        return true;
    }

    public T get(int index){
        if (index < 0 || index >= this.count) {
            throw new RuntimeException("Invalid target index");
        }
        return this.data[index];
    }

    public T getFirst(){
        return this.get(0);
    }

    public T getLast(){
        return this.get(this.count - 1);
    }

    public void removeAt(int index){
        if (index < 0 || index >= this.count) {
            throw new RuntimeException("Invalid target index");
        }

        for(int i = index; i < this.count - 1; i++){
            this.data[i] = this.data[i+1];
        }
        this.data[this.count-1] = null;
        this.count--;
    }

    public int indexOf(T value){
        for (int i = 0; i < this.count; i++) {
            if (this.data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T value){
        for(int i = this.count - 1; i >= 0; i--){
            if (this.data[i] == value) {
                return i;
            }
        }
    
        return -1;
    }

    public void removeFirst(){
        this.removeAt(0);
    }

    public void removeLast(){
        this.removeAt(this.count - 1);
    }
}