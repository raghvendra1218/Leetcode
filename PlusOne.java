package com.raghvendra;

public class PlusOne {
    public int[] plusOne (int[] nums) {
        //traverse the array from last element
        for(int i = nums.length - 1; i >=0; i--){
            if(nums[i] < 9) {
                nums[i] ++;
                return nums;
            }
            nums[i] = 0;
        }
        int[] newNums = new int[nums.length + 1];
        newNums[0] = 1;
        return newNums;
    }
}
