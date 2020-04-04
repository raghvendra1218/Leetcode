package com.raghvendra;

/**
 * Given an array of integers A sorted in non-decreasing order,
 * return an array of the squares of each number, also in sorted non-decreasing order.
 *
 * Example 1:
 *
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Example 2:
 *
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 *
 * Note:
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A is sorted in non-decreasing order.
 */

import java.util.Arrays;

public class SquaresOfASortedArray {
    /**
     * Approach 1: Just traverse the array and square each element in place. At last sort the formed array and return it.
     */
    public int[] sortedSquares(int[] A) {
        int idx = 0;
        for( int a: A) {
            A[idx] *= A[idx];
            idx++;
        }
        Arrays.sort(A);
        return A;
    }

    /**
     * Approach 2: Two pointer, start one pointer backwards for negative number and forward for positive numbers.
     */
    public int[] sortedSquaresII(int[] A) {
        int ptrPositiveDirection = 0, ptrNegativeDirection = 0, N = A.length;
        while(ptrPositiveDirection < N && A[ptrPositiveDirection] < 0) {
            ptrPositiveDirection++;
        }

        //In order to reach the first negative value (or say maximum negative value) we need to decrement by 1 in the ptrPositiveDirection
        ptrNegativeDirection = ptrPositiveDirection - 1;
        int[] result = new int[N];
        int idx = 0;

        //Checking the conditions on both ends in order to avoid index out of bound exception
        while(ptrNegativeDirection >= 0 && ptrPositiveDirection < N) {
            if(A[ptrNegativeDirection] * A[ptrNegativeDirection] < A[ptrPositiveDirection] * A[ptrPositiveDirection]) {
                result[idx++] = A[ptrNegativeDirection] * A[ptrNegativeDirection];
                ptrNegativeDirection--;
            } else {
                result[idx++] = A[ptrPositiveDirection] * A[ptrPositiveDirection];
                ptrPositiveDirection++;
            }
        }

        //Check if all the indexes are traversed both in positive and negative directions
        while(ptrPositiveDirection < N) {
            result[idx++] = A[ptrPositiveDirection] * A[ptrPositiveDirection];
            ptrPositiveDirection++;
        }
        while(ptrNegativeDirection >= 0) {
            result[idx++] = A[ptrNegativeDirection] * A[ptrNegativeDirection];
            ptrNegativeDirection--;
        }

        return result;
    }
}
