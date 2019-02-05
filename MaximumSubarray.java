package com.raghvendra;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int  i = 0;
        int max= Integer.MIN_VALUE;
        int sum = 0;

        while(i<nums.length){
            if(sum < 0){
                sum = 0;
            }
            sum += nums[i];
            if(max < sum){
                max = sum;
            }
            i++;
        }
        return max;
    }
}
