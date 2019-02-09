package com.raghvendra;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> mySet = new HashSet<>();
        for(int a : nums){
            if(mySet.contains(a)){
                return true;
            } else {
                mySet.add(a);
            }
        }
        return false;
    }
}
