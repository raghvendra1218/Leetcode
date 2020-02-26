package com.raghvendra;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int res = 0;
        if(n > 4){
            while(n > 0){
                res+= n/5;
                n /=5;
            }
        }
        return res;
    }
}