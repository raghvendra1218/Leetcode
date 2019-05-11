package com.raghvendra;

/*
Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?

Example 1:
Input: 5
Output: 2
Explanation: 5 = 5 = 2 + 3
Example 2:

Input: 9
Output: 3
Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
Example 3:

Input: 15
Output: 4
Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
Note: 1 <= N <= 10 ^ 9.
 */


/**
 * Intuition : With n consecutive Integers:
 * The first number we can form is : 1 + 2 + 3 + 4 + 5 ......+ n
 * the next number we can form is : 2 + 3 +........+ n + (n + 1)
 *                              or : 1 + 2 + 3 +.........+ n + n
 *                        and then : 1 + 2 + 3 +.........+ n + n + n, and so on.
 * Therefore , a number N can be formed by n consecutive integers, if
 *     N - (1 + 2 + 3 +......+n) % n == 0
 *     N - n(n+1)/2 % n == 0
 */

public class ConsecutiveNumbersSum {
    public int consecutiveNumbersSum(int N) {
        int ans = 0;
        for(int n = 2; n * (n + 1)/2 <= N; ++n){
            if((N - n * (n + 1)/2) % n == 0) ans++;
        }
        return ans + 1;
    }
}
