package com.raghvendra;

//public class FibonacciNumber {
//    public int fib(int N) {
//        int[] memo = new int[N+1];
//        int result = calculateFibonacci(N,memo);
//        return result;
//    }
//
//    private int calculateFibonacci(int N, int[] memo){
//        if(memo[N] != 0) return memo[N];
//        if(N == 0) return 0;
//        if(N == 1) return 1;
//        int fibonacci = calculateFibonacci(N-1, memo) + calculateFibonacci(N-2,memo);
//        memo[N] = fibonacci;
//        return memo[N];
//    }
//}

/*
    Second Approach : Iterative
 */

public class FibonacciNumber {
    public int fib(int N) {
        if(N == 0) return 0;
        if(N == 1) return 1;
        int old = 0, curr = 1, next = 0;
        for(int i = 2; i <=N; ++i){
            next = curr + old;
            old = curr;
            curr = next;
        }
        return curr;
    }
}