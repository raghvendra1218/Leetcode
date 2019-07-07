package com.raghvendra;

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
 * In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively.
 * Also given an integer W which represents knapsack capacity,
 * find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
 * You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 */

public class KnapsackProblem_0_1 {
    /**
     * Approach 1: Recursion
     * @param wts
     * @param prices
     * @param W
     * @param N
     * @return
     */
    public int knapsack(int[] wts, int[] prices, int W, int N){
        //If the Number of items becomes zero i.e. N equals to zero or when the Weight becomes zero
        //These are our base cases
        if(N == 0 || W == 0) return 0;

        //Here are our two options either to include the weight or not to include the weight, with motto to get the maximum price at the end
        //of the deal. so we will recurse by including and excluding the weight and return the max of the include or exclude the weight.

        int include = 0 , exclude = 0;

        //Including the weight, if it can be fit in the bag of overall weight W
        if(wts[N - 1] <= W){
            include = prices[N - 1] + knapsack(wts, prices, W - wts[N - 1], N - 1);
        }

        //Exclude the current weight
        exclude = knapsack(wts,prices, W, N - 1);

        return Math.max(include,exclude);
    }
}
