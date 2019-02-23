package com.raghvendra;

import java.util.*;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> myMap = new HashMap<>();
        for(int i = 0; i<nums.length; ++i){
            if(myMap.containsKey(nums[i])){
                myMap.put(nums[i], myMap.get(nums[i])+1);
            } else {
                myMap.put(nums[i], 1);
            }
        }
        LinkedHashMap<Integer, Integer> reverseSortedMap = new LinkedHashMap<>();
            myMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
        System.out.println(reverseSortedMap);
        for(Map.Entry<Integer,Integer> entry : reverseSortedMap.entrySet()){
            if(k > 0){
                result.add(entry.getKey());
                k--;
            } else break;
        }
        return result;
    }
}
