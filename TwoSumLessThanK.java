package com.raghvendra;

import java.util.Arrays;

/**
 * Given an array A of integers and integer K, return the maximum S such that there exists i < j with A[i] + A[j] = S
 * and S < K. If no i, j exist satisfying this equation, return -1.
 *
 * Example 1:
 *
 * Input: A = [34,23,1,24,75,33,54,8], K = 60
 * Output: 58
 * Explanation:
 * We can use 34 and 24 to sum 58 which is less than 60.
 * Example 2:
 *
 * Input: A = [10,20,30], K = 15
 * Output: -1
 * Explanation:
 * In this case it's not possible to get a pair sum less that 15.
 */

/**
 * Approach : Step 1: Sort the Array
 *            Step 2: Traverse teh array from both sides, and check for the target sum , if sum of values at both ends
 *                    exceeds, decrease the end index by 1, meaning there is no sum which could be formed either by
 *                    increasing start or increasing end.
 *                    Now, in the case when the sum is less than K, then store the max sum by comparing with the previous
 *                    max value of sum. and in this case we also need to iterate start, as there could be a chance from
 *                    current start till end to find a value whose sum could be greater than existing max sum, if found
 *                    update the max sum and if during iteration you find values sum greater than K, the inner loop will
 *                    break and end will be decreased by 1.
 */
public class TwoSumLessThanK {
    public int twoSumLessThanK(int[] A, int K) {
        int start = 0;
        int end = A.length - 1;
        int sum = -1;
        Arrays.sort(A);
        while(start < end){
            while( start < end && A[start] + A[end] < K){
                sum = Math.max(sum, A[start] + A[end]);
                start++;
            }
            if(A[start] + A[end] >= K){
                end--;
            }
        }
        return sum;
    }
}
