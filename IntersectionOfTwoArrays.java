package com.raghvendra;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> myset1 = new HashSet<>();
        Set<Integer> myset2 = new HashSet<>();
        for(int i : nums1){
            myset1.add(i);
        }
        for(int i : nums2){
            if(myset1.contains(i)){
                myset2.add(i);
            }
        }
        int [] resultArray = new int[myset2.size()];
        int j = 0;
        for(Integer i : myset2){
            resultArray[j] = i;
            j++;
        }
        return resultArray;
    }
}
