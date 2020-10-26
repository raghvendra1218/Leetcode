package com.raghvendra;

public class RunningSumOf1dArray {
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int cumSum = 0;

        for(int i = 0; i < nums.length; ++i) {
            cumSum += nums[i];
            result[i] = cumSum;
        }

        return result;
    }
}
