package com.raghvendra;

public class SqrtX {
    public int mySqrt(int x) {
        long start = 1;
        long end = x;
        while(start <= end){
            long mid = start + (end - start)/2;
            if(mid * mid == x){
                return (int)mid;
            } else if( mid * mid < x){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return (int)end;
    }
}
