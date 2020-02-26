package com.raghvendra;

/*
Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

Example 1:
Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Note:

0 < nums.length <= 50000.
0 < nums[i] < 1000.
0 <= k < 10^6.
*/

/**
 * Intuition :  Use Sliding window, and as we progress further we notice two things
 * Number of Count for combinations has a pattern which is for each increment in end pointer the number of combinations less than k
 * follow rule count += end - start + 1
 * For each increase in end we check if the product is less than equal to k and if not then,
 * dividing the product by nums[start] till the product >= k and we increment start
 * At last return the count
 */
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
