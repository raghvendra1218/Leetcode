package com.raghvendra;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int [] memo = new int[n+1];
        int result =  countSteps(n,memo);
        return result;
    }

    private int countSteps(int n, int[] memo){
        if(memo[n] !=  0) return memo[n];
        if(n == 0 || n == 1) return 1;
        int steps = countSteps(n-1,memo) + countSteps(n-2,memo);
        memo[n] = steps;
        return memo[n];
    }
}

/*
    Second Approach :  Using iterative solution
 */
//public class ClimbingStairs {
//    public int climbStairs(int n) {
//        if(n == 0 || n == 1) return 1;
//        int old = 1, curr = 1, next = 0;
//        for(int i =2; i <= n; ++i){
//            next = old + curr;
//            old = curr;
//            curr = next;
//        }
//        return curr;
//    }
//}
