package com.raghvendra;

/* Number of allowed steps = k (i.e. :  1, 2, 3, ......k)
Number of Steps is denoted by n
*/

public class ClimbingStairsWithKSteps {
    /**Approach 1: Using Recursion
    * Time Complexity : O(n ki power k)
     * Space Complexity: O(n)
     */

    int ways(int n, int k){
        if (n == 0) return 1;
        if(n < 0) return 0;

        int ans = 0;

        for(int j = 1; j<=k; ++j){
            ans += ways(n - j, k);
        }

        return ans;
    }

    /**
     * Approach 2: Using Bottom Up Approach
     * Time Complexity : O(n * k)
     * Space Complexity : O(n)
     */
    int waysBU(int n, int k){
        int[] dp = new int[n];
        dp[0] = 1;

        for(int step = 1; step <= k; step++){
            dp[step] = 0;
            for(int j = 1; j <= k; j++){
                //Checking steps does not go out of bound in dp array
                if(step - j >= 0){
                    dp[step] += dp[step - j];
                }
            }
        }
        return dp[n];
    }

    /**
     * Approach 3: Using Bottom Up  Approach
     * Time Complexity : O(n)
     * Space Complexity: O(n)
     */
    int waysBUOptimized(int n, int k){
        int[] dp = new int[n];
        dp[0] = 1;

        for(int step = 1; step <= k; step++){
            dp[step] = 2 * dp[step] - dp[step - k];
        }
        return dp[n];
    }
}
