package com.raghvendra;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k.
 * If there isn't one, return 0 instead.
 *
 * Note:
 * The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
 *
 * Example 1:
 *
 * Input: nums = [1, -1, 5, -2, 3], k = 3
 * Output: 4
 * Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
 * Example 2:
 *
 * Input: nums = [-2, -1, 2, 1], k = 1
 * Output: 2
 * Explanation: The subarray [-1, 2] sums to 1 and is the longest.
 * Follow Up:
 * Can you do it in O(n) time?
 */

public class MaximumSizeSubarraySumEqualsk {
    public int maxSubArrayLen(int[] nums, int k) {
        // We will create a HashMap and store the sum of the all the elements before current index i as key and i as
        // value.
        int sum = 0;
        int maxSizeSubArrayLength = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();

        //Traverse through the array
        for(int  i = 0; i < nums.length; ++i){
            sum += nums[i];
            //Check if sum equals to k then update the maxSizeSubArrayLength
            if(sum == k) maxSizeSubArrayLength = i + 1;
            else if(sumMap.containsKey(sum - k)) {
                maxSizeSubArrayLength = Math.max(maxSizeSubArrayLength, i - sumMap.get(sum - k));
            }
            if(!sumMap.containsKey(sum)){
                sumMap.put(sum, i);
            }
        }
        return maxSizeSubArrayLength;
    }
}
