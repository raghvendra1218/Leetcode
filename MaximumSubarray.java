package com.raghvendra;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int i = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        while(i < nums.length){
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
