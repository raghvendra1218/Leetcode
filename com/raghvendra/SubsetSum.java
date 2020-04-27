package com.raghvendra;

/**
 * Find whether the given sum could be obtained from a given array or not.
 * This is variant of Knapsack(0-1) problem
 */
public class SubsetSum {
    /**
     * Approach 1: Recursive
     * @param nums
     * @param K
     * @return
     */
    public boolean isSubsetAvailable(int[] nums, int K, int N) {
        //Base Case
        if(K == 0) {
            return true;
        }
        if(N == 0 && K > 0) {
            return false;
        }

        if(nums[N - 1] <= K) {
            return  isSubsetAvailable(nums, K - nums[N - 1], N - 1) || isSubsetAvailable(nums, K, N - 1);
        }
        else {
            return isSubsetAvailable(nums, K, N - 1);
        }
    }

    /**
     * Approach 2: Recursive and memoization
     */
//    boolean[][] t = new boolean[K + 1][N + 1];
//    public boolean isSubsetAvailableII(int[] nums, int K, int N) {
//        //Base Case
//        if(K == 0) {
//            return true;
//        }
//        if(N == 0 && K > 0) {
//            return false;
//        }
//
//        if(nums[N - 1] <= K) {
//            return  isSubsetAvailableII(nums, K - nums[N - 1], N - 1) || isSubsetAvailableII(nums, K, N - 1);
//        }
//        else {
//            return isSubsetAvailableII(nums, K, N - 1);
//        }
//    }

    /**
     * Approach 3 : Dynamic Programming, we have simplified the base case for initializing the matrix zeroth row and columns
     *              After that we have used the generic recursive calls to fill the rest of the blocks in the matrix
     */
    public boolean isSubsetAvailableIII(int[] nums, int K, int N) {
        boolean[][] t = new boolean[N + 1][K + 1];

        for(int i = 0; i < t.length; ++i) {
            for(int j = 0; j < t[0].length; ++j) {
                if(i == 0) {
                    t[i][j] = false;
                } else if(j == 0) {
                    t[i][j] = true;
                } else if (nums[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - nums[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[N][K];
    }
}
