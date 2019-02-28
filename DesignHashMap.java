package com.raghvendra;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class DesignHashMap {
    /**
     * Approach -1 : Naive Solution, Space Complexity is very high in this solution
     * Time Complexity : O(1)
     * Space Complexity : O(n)
     */

    /** Initialize your data structure here. */
//    private int[] bucket ;
//
//    public DesignHashMap() {
//        bucket = new int[1000000];
//        Arrays.fill(bucket, Integer.MIN_VALUE);
//    }
//
//    /** value will always be non-negative. */
//    public void put(int key, int value) {
//        bucket[key] = value;
//    }
//
//    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
//    public int get(int key) {
//        if(bucket[key] == Integer.MIN_VALUE) return -1;
//        return bucket[key];
//    }
//
//    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
//    public void remove(int key) {
//        bucket[key] = Integer.MIN_VALUE;
//    }

    /**
     * Apporach -2 Generating the Hash key and storing the values according to it
     * Time Complexity :  WorstCase O(size of List at one index)
     * Space Complexity : O(size of 1000000 % n);
     */

    /** Initialize your data structure here. */
    private List<Pair<Integer,Integer>>[] bucket ;

    public DesignHashMap() {
        bucket = new List[1000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        Pair<Integer, Integer> pair = new Pair<>(key,value);
        int modulatedKey = key % bucket.length;
        if(bucket[modulatedKey] == null) bucket[modulatedKey] = new ArrayList<>();
        int index = 0;
        boolean flag = false;
        for(Pair<Integer,Integer> p : bucket[modulatedKey]){
            if(p.getKey() == key){
                bucket[modulatedKey].set(index, pair);
                flag = true;
                break;
            }
            index++;
        }
        if(!flag){
            bucket[modulatedKey].add(pair);
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int modulatedKey = key % bucket.length;
        System.out.println(modulatedKey);
        if(bucket[modulatedKey] == null) return -1;
        for(Pair<Integer,Integer> p : bucket[modulatedKey]){
            if(p.getKey() == key) return p.getValue();
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int modulatedKey = key % bucket.length;
        if(bucket[modulatedKey] == null) return;
        int index =0 ;
        for(Pair<Integer, Integer> pair : bucket[modulatedKey]){
            if(pair.getKey() == key) {
                bucket[modulatedKey].remove(index);
                break;
            }
            index++;
        }
    }
}
