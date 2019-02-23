package com.raghvendra;

public class ProductOfArrayExceptSelf {
    /*
    Approach 1: Using Two Temporary Arrays
     */
//    public int[] productExceptSelf(int[] nums) {
//        int[] leftToRight = new int[nums.length];
//        int[] rightToLeft = new int[nums.length];
//        leftToRight[0] = 1;
//        rightToLeft[nums.length-1] =1;
//        for(int i = 1; i<nums.length; ++i){
//            leftToRight[i] = leftToRight[i-1]*nums[i-1];
//        }
//        for(int i = nums.length-2; i >=0; --i){
//            rightToLeft[i] = rightToLeft[i+1] * nums[i+1];
//        }
//        for(int i = 0; i<nums.length; ++i){
//            nums[i] = leftToRight[i] * rightToLeft[i];
//        }
//        return nums;
//    }

    /*
    Approach 2: Using only one Temporary Array
     */
    public int[] productExceptSelf(int[] nums) {
        int[] leftToRight = new int[nums.length];
        leftToRight[0] =1;
        for(int i = 1; i <nums.length; ++i){
            leftToRight[i] = leftToRight[i-1] * nums[i-1];
        }
        int right = 1;
        for(int i = nums.length-2; i>=0; --i){
            right = right * nums[i+1];
            leftToRight[i] = right * leftToRight[i];
        }
        return leftToRight;
    }
}