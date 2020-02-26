package com.raghvendra;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> myMap = new HashMap<>();
        for(int i = 0; i <nums.length; i++){
            if(myMap.containsKey(nums[i])){
                if(i - myMap.get(nums[i]) <= k) return true;
            }
            myMap.put(nums[i],i);
        }
        return false;
    }
}
