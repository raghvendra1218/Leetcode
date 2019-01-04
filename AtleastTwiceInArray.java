package com.raghvendra;

public class AtleastTwiceInArray {
    public int dominantIndex (int[] nums) {
        int index = 0;
        int max = 0;
        if(nums.length <=1) {
            return index;
        }
        //find the largest number in the array
        for(int i =0 ; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        //To check if the max element in the array is at least twice the others in the array
        for(int i = 0 ; i < nums.length; i++) {
            if(2*nums[i] > max && index != i) {
                return -1;
            }
        }
        return index;
    }
}
