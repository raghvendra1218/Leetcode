package com.raghvendra;

public class DivisorGame {

    /**Approach 1: If we try to write the Number on pen and paper and play the game, we will figure it out that when a user leaves an odd number
     * for other player, then the other player looses, so the strategy is to avoid getting odd number for Alice (if there is an option)
     * In case if Alice is presented with odd Number, then there is definite loosing for Alice.
     */
    public boolean divisorGame(int N) {
        if(N%2 != 0) return false;
        return true;
    }

    /** Approach 2: If we are unable to figure out the above pattern odd/even, still we can see that we are calculating for each Number,
     * we somehow get an idea, that D.P. will be used for performance optimization.
     * For evey N we are calculating the
     */
    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N + 1];
        dp[0] = false;
        dp[1] = false;

        for(int i = 2; i <=N; ++i){
            for(int j = 1; j < i; ++j){
                if(i % j == 0){
                    if(dp[i - j] == false){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[N];
    }
}
