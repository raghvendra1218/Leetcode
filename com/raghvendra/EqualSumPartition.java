package com.raghvendra;

/**
 * Are there two sets which have both sum equal?
 * Example nums : {1, 5, 11, 5}, result : True
 * Example nums : {1, 8, 10, 2} result : false
 * Example nums : {1, 8, 11, 2} result : true
 */
public class EqualSumPartition {
    public boolean containsEqualSumPartition(int[] nums, int N) {
        int sum = 0;
        for(int s: nums) {
            sum += s;
        }
        if(sum %2 != 0) return false;
        else return isSubsetAvailable(nums, sum/2, N);  //idea here is , if we find first half then remaining other half is other subset
    }

    private boolean isSubsetAvailable(int[] nums, int K, int N) {
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
