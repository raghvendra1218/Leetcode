package com.raghvendra;

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * Intuition:
 *************
 * There are three cases, we have to deal
 * first Case : When the current element is positive ex: -1, 6, 2, 3(current element)
 * second Case : When the current element is negative ex : -1, 6, 2, -2(current element) ,
 * in this case we should also keep track of prev min product, which is -12 in this case, which will give 24 when multiplied by -2 and that should be the answer
 * Third Case : When the current element is starting position. ex: -1, 6, 2, 0, 7 (current element), 9 . In this case answer should be 63
 * So at each point we need to find current max product, current min product keeping the history for prev max and min products for these three cases
 * We will initialise the currentmax/currentmin/prevmax/prevmin with nums[0], in order to avoid the boundary case when there is only one element in array.
 *
 * Time Complexity : O(n)
 * Space Complexity: O(n)
 */

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;

        int curr_max_product = nums[0];
        int curr_min_product = nums[0];
        int prev_max_product = nums[0];
        int prev_min_product = nums[0];
        int ans = nums[0];

        //Traverse through the array once
        for(int i = 1; i < nums.length; ++i){
            curr_max_product = Math.max(prev_max_product * nums[i], Math.max(prev_min_product * nums[i], nums[i]));
            curr_min_product = Math.min(prev_max_product * nums[i], Math.min(prev_min_product * nums[i], nums[i]));
            ans = Math.max(curr_max_product, ans);
            prev_max_product = curr_max_product;
            prev_min_product = curr_min_product;
        }
        return ans;
    }
}
