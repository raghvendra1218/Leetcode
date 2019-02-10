package com.raghvendra;

public class SqrtX {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        for(int i =1; i<=x/i; i++){
            if(i*i == x){
                return i;
            } else if(i*i > x){
                return i-1;
            }
        }
        return -1;
    }
}
