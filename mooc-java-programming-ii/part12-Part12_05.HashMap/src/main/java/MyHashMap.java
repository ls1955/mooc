/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cheong
 */

import java.util.ArrayList;

public class MyHashMap<K, V> {
    private ArrayList<Pair<K, V>>[] buckets;
    private int pairAmount;

    public MyHashMap() {
        this.buckets = new ArrayList[32];
        this.pairAmount = 0;
    }
    
    public V get(K key) {
        ArrayList<Pair<K, V>> bucket = getBucketFromKey(key);
        
        for (int i = 0; i < bucket.size(); i++) {
            Pair<K, V> currPair = bucket.get(i);
            
            if (currPair.getKey().equals(key)) {
                return currPair.getValue();
            }
        }
        
        return null;
    }
    
    public void add(K key, V value) {
        ArrayList<Pair<K, V>> bucket = getBucketFromKey(key);
        int indexOfKey = getIndexFromKey(bucket, key);
        
        if (indexOfKey == -1) {
            bucket.add(new Pair(key, value));
            pairAmount++;
        } else {
            bucket.set(indexOfKey, new Pair(key, value));
        }
        
        if (1.0 * pairAmount / buckets.length >= 0.75) growBuckets();
    }
    
    public V remove(K key) {
        ArrayList<Pair<K, V>> bucket = getBucketFromKey(key);
        
        if (bucket.isEmpty()) return null;
        
        int index = getIndexFromKey(bucket, key);
        
        if (index == -1) return null;
        
        Pair<K, V> removedPair = bucket.get(index);
        bucket.remove(index);
        
        return removedPair.getValue();
    }
    
    private ArrayList<Pair<K, V>> getBucketFromKey(K key) {
        int hashCode = Math.abs(key.hashCode() % buckets.length);
        
        if (buckets[hashCode] == null) buckets[hashCode] = new ArrayList<>();
        
        return buckets[hashCode];
    }
    
    private int getIndexFromKey(ArrayList<Pair<K, V>> bucket, K key) {
        for (int i = 0; i < bucket.size(); i++) {
            Pair<K, V> currPair = bucket.get(i);
            
            if (currPair.getKey().equals(key)) {
                return i;
            }
        }
        
        return -1;
    }
    
    private void growBuckets() {
        ArrayList<Pair<K, V>>[] newBuckets = new ArrayList[2 * buckets.length];
        
        for (int i = 0; i < buckets.length; i++) {
            copyTo(newBuckets, i);
        }
        
        buckets = newBuckets;
    }
    
    private void copyTo(ArrayList<Pair<K, V>>[] newBuckets, int index) {
        for (int i = 0; i < buckets[index].size(); i++) {
            Pair<K, V> currPair = buckets[index].get(i);
            int hashCode = Math.abs(currPair.getKey().hashCode() % buckets.length);
            
            if (newBuckets[hashCode] == null) newBuckets[hashCode] = new ArrayList<>();
            
            newBuckets[hashCode].add(currPair);
        }
    }
}
