package com.raghvendra;

import java.util.ArrayList;
import java.util.List;

/**
 * Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.
 *
 * Note that every number in the answer must not have leading zeros except for the number 0 itself.
 * For example, 01 has one leading zero and is invalid, but 0 is valid.
 *
 * You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: N = 3, K = 7
 * Output: [181,292,707,818,929]
 * Explanation: Note that 070 is not a valid number, because it has leading zeroes.
 * Example 2:
 *
 * Input: N = 2, K = 1
 * Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 *
 * Note:
 *
 * 1 <= N <= 9
 * 0 <= K <= 9
 */
/*
Intuition : We can pick a digit from 1 to 9, let;s say d.
            Add and subtract K from this digit, with the condition; d - K >=0 and d + K < 10
            we can include only those numbers in the result set which satisfies above condition, with every time multiplying the digit on each level by 10
            and adding it with previous digit.
            We need to repeat this step until N becomes 0
            Special case I: when N == 1, then we need to include 0 as well in the result set
            Special case II: when K = 0 then the result set will have repeated numbers. we need to handle that as well.
 */
public class NumbersWithSameConsecutiveDifferences {
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> result = new ArrayList<>();
        if (N == 1) result.add(0);
        for(int d = 1; d < 10; ++d) {
            //Since we have already added one digit, hence we are sending N-1
            dfs(d, N - 1, K, result);
        }

        //Convert array list to array to make it compatible to function signature
        int[] resultArray = new int[result.size()];
        int idx = 0;
        for(int n : result) {
            resultArray[idx] = n;
            idx++;
        }

        return resultArray;
    }

    private void dfs(int num, int N, int K, List<Integer> result) {
        //Base condition
        if (N == 0) {
            result.add(num);
            return;
        }
        //find the last digit (basically individual digits at their place), as it will be required to calculate the +/- values
        //to the K and see if it lies in the range.
        int last_digit = num % 10;

        if(last_digit >= K) dfs(num*10 + last_digit - K, N - 1, K, result);

        //K > 0 condition to handle special case II mentioned in the intuition
        if(K >0 && last_digit + K < 10) dfs(num*10 + last_digit + K, N - 1, K, result);
    }
}


