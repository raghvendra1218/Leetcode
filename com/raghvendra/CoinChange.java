package com.raghvendra;
/**
 You are given coins of different denominations and a total amount of money amount.
 Write a function to compute the fewest number of coins that you need to make up that amount.
 If that amount of money cannot be made up by any combination of the coins, return -1.

 Example 1:

 Input: coins = [1, 2, 5], amount = 11
 Output: 3
 Explanation: 11 = 5 + 5 + 1
 Example 2:

 Input: coins = [2], amount = 3
 Output: -1
 Note:
 You may assume that you have an infinite number of each kind of coin.

 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] amt = new int[amount + 1];

        //Initialise amt's each index with amount + 1 value, (kind of INTEGER.MAX_VALUE , value cannot be more than amount + 1)
        //So it is safe to initialise value with 1 more than given amount value
        for(int i = 0 ; i < amt.length; ++i){
            amt[i] = amount + 1;
        }

        //Initialising the zeroth index as zero, because we will require zero coins to fulfil the amount value equal to zero
        amt[0] = 0;

        //Iterating through the each amount value till eachAmount reaches desired amount value
        //During this process we are calculating minimum number of coins to satisfy eachAmount value
        for(int eachAmount = 1; eachAmount <= amount; eachAmount++){
            for(int coinIndex = 0; coinIndex < coins.length; coinIndex++){

                //check if the value of eachAmount is less than the coin picked
                if(coins[coinIndex] <= eachAmount){
                    amt[eachAmount] = Math.min(amt[eachAmount - coins[coinIndex]] + 1, amt[eachAmount]);
                }
            }
        }

        //check if the denominations exists for the given amount, if yes then return the corresponding values, else return -1
        if(amt[amount] != amount + 1){
            return amt[amount];
        } else {
            return -1;
        }
    }
}
