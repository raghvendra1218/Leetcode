package com.raghvendra;

import java.util.HashMap;
import java.util.Map;

public class DotProductOfTwoSparseVectors {

    private Map<Integer, Integer> map;  //key -> index , value -> data at index of array
    public DotProductOfTwoSparseVectors(int[] nums) {
        map = new HashMap<>();
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] != 0) map.put(i, nums[i]);
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(DotProductOfTwoSparseVectors vec) {
        if (map.size() == 0 || vec.map.size() == 0) return 0; // case when either of map has all zero, no need to find the dot product because it will be zero
        if (map.size() > vec.map.size())
            return vec.dotProduct(this); //we always want the smaller size map to iterate
        int productSum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int index = entry.getKey();
            Integer vecValue = vec.map.get(index);
            if (vecValue == null) continue;
            productSum += (entry.getValue() * vecValue);
        }
        return productSum;
    }
}
