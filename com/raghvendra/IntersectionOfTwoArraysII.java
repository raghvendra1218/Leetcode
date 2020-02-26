package com.raghvendra;

import java.util.*;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> myMap = new HashMap<>();
        List<Integer> temp = new ArrayList<>();

        for(int i : nums1){
            myMap.put(i, myMap.getOrDefault(i,0)+1);
        }
        //Traverse through the nums2 and check if the element exists in the myMap and decrease the count of that key every time you add
        //in the result ArrayList
        for(int i : nums2){
            if(myMap.containsKey(i) && myMap.get(i) > 0){
                temp.add(i);
                myMap.put(i,myMap.get(i)-1);
            }
        }

        int[] result = new int[temp.size()];
        for (int i = 0; i< temp.size(); ++i){
            result[i] = temp.get(i);
        }
        return result;
    }
}
