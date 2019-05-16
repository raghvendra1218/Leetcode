package com.raghvendra;

/*
Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.



Example 1:

Input: A = [4,5,0,-2,-3,1], K = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by K = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

Note:

1 <= A.length <= 30000
-10000 <= A[i] <= 10000
2 <= K <= 10000
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Approach 1: Using an Auxiliary Array
 */
public class SubarraySumsDivisibleByK {
/*    public int subarraysDivByK(int[] A, int K) {
        int[] map = new int[K];
        map[0] = 1;
        int count = 0, sum = 0;
        for(int a : A) {
            sum = (sum + a) % K;
            if(sum < 0) sum += K;  // Because -1 % 5 = -1, but we need the positive mod 4
            count += map[sum];
            map[sum]++;
        }
        return count;
    }*/

/**
 * Approach 2: Using HashMap
 */
    public int subarraysDivByK(int[] A, int K) {
        int count  = 0;
        Map<Integer, Integer> myMap = new HashMap<>();
        int cumSum = 0;
        myMap.put(0,1);
        for(int i : A){
            cumSum = (cumSum + i) % K;
            if(cumSum < 0){
                cumSum += K;
            }
            count += myMap.getOrDefault(cumSum, 0);
            myMap.put(cumSum, myMap.getOrDefault(cumSum,0) +1);
        }
        return count;
    }
}
