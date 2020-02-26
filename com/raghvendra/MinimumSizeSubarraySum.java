package com.raghvendra;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray
 * of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int slow, fast;
        slow = fast = 0;
        int minSize = Integer.MAX_VALUE;

        //We will subtract the each element value traversed and keep the minimum length encountered in minSize var.
        while(fast < nums.length){
            s -= nums[fast];
            // We will check for the condition (which is s <=0 ) till it holds true, because ideally that is the case
            // which will give us the minimum length
            while( s <= 0){
                int currLength = fast - slow + 1;
                if(currLength < minSize){
                    minSize = currLength;
                }
                // We will now add the slow index value to our existing s, to check if it still qualifies for condition
                // s<=0
                s += nums[slow];
                slow++;
            }
            fast++;
        }
        return (minSize == Integer.MAX_VALUE) ? 0 : minSize;
    }
}
