package com.raghvendra;

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