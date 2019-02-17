package com.raghvendra;
/*
    Finding Prime numbers - Sieve of Eratosthenes
 */

public class CountPrimes {
    public int countPrimes(int n) {
        boolean [] digits = new boolean[n];
        int count = 0;
        for(int i = 2; i <n ; ++i){
            if(!digits[i]) {
                count++;
                for (int j = 2; j * i < n; j++) {
                    digits[j * i] = true;
                }
            }
        }
        return count;
    }
}