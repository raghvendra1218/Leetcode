package com.raghvendra;

import java.util.*;

public class TopKFrequentElements {
    /**
    Approach 1: Using HashMap and then sorting the HashMap values
     */
//    public List<Integer> topKFrequent(int[] nums, int k) {
//        List<Integer> result = new ArrayList<>();
//        Map<Integer, Integer> myMap = new HashMap<>();
//        for(int i = 0; i<nums.length; ++i){
//            if(myMap.containsKey(nums[i])){
//                myMap.put(nums[i], myMap.get(nums[i])+1);
//            } else {
//                myMap.put(nums[i], 1);
//            }
//        }
//        LinkedHashMap<Integer, Integer> reverseSortedMap = new LinkedHashMap<>();
//            myMap.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
//
//        for(Map.Entry<Integer,Integer> entry : reverseSortedMap.entrySet()){
//            if(k > 0){
//                result.add(entry.getKey());
//                k--;
//            } else break;
//        }
//        return result;
//    }
    /**
    Approach 2: Using HashMap and Priority Queue
     */

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> myMap = new HashMap<>();
        //Store the values by count in HashMap
        for(int n : nums){
            myMap.put(n, myMap.getOrDefault(n,0) +1);
        }

        //Create a heap, element with least frequency at the top
        PriorityQueue<Integer> myHeap = new PriorityQueue<>((x, y) -> myMap.get(x) - myMap.get(y));

        //Keep the k top frequent elements in the heap
        for(int n : myMap.keySet()){
           myHeap.add(n);
           if(myHeap.size() > k){
               myHeap.poll();
           }
        }

        //Add the elements in the result list and reverse the list
        while(!myHeap.isEmpty()){
            result.add(myHeap.poll());
        }
        Collections.reverse(result);
        return result;
    }
}
