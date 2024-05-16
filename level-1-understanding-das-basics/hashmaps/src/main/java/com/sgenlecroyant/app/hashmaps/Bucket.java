package com.sgenlecroyant.app.hashmaps;

public class Bucket<K,V> {
    
    private K key;
    private V value;

    public Bucket(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
