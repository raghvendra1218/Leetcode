package com.raghvendra;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1)return 0;
        int count  = 0;
        int product  = 1;
        int start = 0 , end = 0;
        while (end < nums.length){
            product *= nums[end];
            while (start <= end && product >= k){
                product /= nums[end];
                start++;
            }
            count += end - start + 1;
            end ++;
        }
        return count;
    }
}
