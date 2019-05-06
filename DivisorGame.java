package com.raghvendra;
/*
Alice and Bob take turns playing a game, with Alice starting first.

Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:

Choosing any x with 0 < x < N and N % x == 0.
Replacing the number N on the chalkboard with N - x.
Also, if a player cannot make a move, they lose the game.

Return True if and only if Alice wins the game, assuming both players play optimally.



Example 1:

Input: 2
Output: true
Explanation: Alice chooses 1, and Bob has no more moves.
Example 2:

Input: 3
Output: false
Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.


Note:

1 <= N <= 1000
 */

public class DivisorGame {

    /**Approach 1: If we try to write the Number on pen and paper and play the game, we will figure it out that when a user leaves an odd number
     * for other player, then the other player looses, so the strategy is to avoid getting odd number for Alice (if there is an option)
     * In case if Alice is presented with odd Number, then there is definite loosing for Alice.
     */
//    public boolean divisorGame(int N) {
//        if(N%2 != 0) return false;
//        return true;
//    }

    /** Approach 2: If we are unable to figure out the above pattern odd/even, still we can see that we are calculating for each Number,
     * we somehow get an idea, that D.P. will be used for performance optimization.
     * For evey N we are calculating the
     */
    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N + 1];
        dp[0] = false;
        dp[1] = false;

        for(int i = 2; i <= N; ++i){
            for(int j = 1; j < i; ++j){
                if(i % j == 0){
                    if(!dp[i - j]){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[N];
    }
}
