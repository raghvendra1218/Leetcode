package com.raghvendra;

/**
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
 *
 *
 *
 * Example 1:
 *
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * Example 2:
 *
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * Example 3:
 *
 * Input: amount = 10, coins = [10]
 * Output: 1
 *
 *
 * Note:
 *
 * You can assume that
 *
 * 0 <= amount <= 5000
 * 1 <= coin <= 5000
 * the number of coins is less than 500
 * the answer is guaranteed to fit into signed 32-bit integer
 */
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        //Take an array of size amount + 1, so that we can acommodate all the possible denominations
        int amt[] = new int[amount + 1];

        //initialise each element of array with 0
        for(int i = 0; i < amt.length; ++i){
            amt[i] = 0;
        }

        //initialise the first index of amt with 0, since there is one way to choose amount equal to zero
        amt[0] = 1;

        for(int coinIndex = 0; coinIndex < coins.length; coinIndex++){
            for(int eachAmount = 1; eachAmount < amt.length; eachAmount++){
                if(coins[coinIndex] <= eachAmount){
                    amt[eachAmount] = amt[eachAmount - coins[coinIndex]] + amt[eachAmount];
                }
            }
        }
        return amt[amount];
    }
}