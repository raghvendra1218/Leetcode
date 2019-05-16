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
        int ans = 0;
        //Let's initiate an array to store the cumulative sum at each index
        int[] P = new int[A.length + 1];
        for(int i = 0; i < P.length; i++){
            P[i + 1] = A[i] + P[i];
        }
        //initialize an array for length equal to K, trying to fit in cyclicity
        int[] count = new int[K];
        for(int i : P){
            count[(i % K + K) % K] ++;
        }

        for(int n : count){
            ans += (n * (n - 1))/2;
        }
        return ans;
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
