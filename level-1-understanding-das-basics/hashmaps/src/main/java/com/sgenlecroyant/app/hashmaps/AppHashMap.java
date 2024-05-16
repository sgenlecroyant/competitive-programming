package com.sgenlecroyant.app.hashmaps;

import java.util.LinkedList;
import java.util.List;

public class AppHashMap<K,V> {

    private int count;
    private List<Bucket<K,V>> data;

    public AppHashMap(){
        this.data = new LinkedList<>();
    }
    public AppHashMap(int capacity){
        this.data = new LinkedList<>();
    }

    public boolean put(K key, V value){
        return this.putValue(key, value);
    }

    private boolean putValue(K key, V value) {
        int hashedKey = this.hash(key);
        int index = 0;
        boolean doesKeyExist = false;
        for (Bucket<K, V> datum : this.data) {
            int datumHashedKey = this.hash(datum.getKey());
            if (datumHashedKey == hashedKey) {
                this.data.set(index, new Bucket<>(key,value));
                doesKeyExist = true;
                break;
            }
            index++;
        }
        if (!doesKeyExist){
            this.data.add(new Bucket<>(key,value));
            this.count++;
        }
        return true;
    }

    public int size() {
        return count;
    }

    private int hash(K key){
        return key.hashCode();
    }

    public void printKeyValue(){
        System.out.println("===printing===");
        for(Bucket<K,V> bucket: this.data){
            System.out.println(bucket.getKey()+ ":" +bucket.getValue());
        }
    }

    public V get(K key){
        int hashedTargetKey = this.hash(key);
        for (Bucket<K,V> bucket: this.data){
            if (this.hash(bucket.getKey()) == hashedTargetKey){
                return bucket.getValue();
            }
        }
        return null;
    }

    public V getOrDefault(K key, V defaultValue){
        int hashedTargetKey = this.hash(key);
        for (Bucket<K,V> bucket: this.data){
            if (this.hash(bucket.getKey()) == hashedTargetKey){
                return bucket.getValue();
            }
        }
        return defaultValue;
    }
}