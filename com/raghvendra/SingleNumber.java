package com.raghvendra;

/*
XOR :
N^0 = N
N^N = 0
XOR is associative and commutative, so it will work even if the repeated number are dispersed in an array
 */



public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int a : nums) {
            ans ^= a;
        }
        return ans;
    }
}
