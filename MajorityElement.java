package com.raghvendra;

/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> myMap = new HashMap<>();
        for(int i = 0; i<nums.length; ++i){
            if(myMap.containsKey(nums[i])){
                myMap.put(nums[i],myMap.get(nums[i])+1);
            } else {
                myMap.put(nums[i],1);
            }
        }
        Integer max = Collections.max(myMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        return max;
    }
}
