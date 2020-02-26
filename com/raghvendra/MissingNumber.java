package com.raghvendra;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int sumFirstN_Numbers = 0;
        int numsLength  = nums.length;
        for(int i = 0; i < nums.length; ++i){
            sum += nums[i];
        }
        sumFirstN_Numbers = (numsLength*(numsLength+1))/2;
        return sumFirstN_Numbers - sum;
    }
}
