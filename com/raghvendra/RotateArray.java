package com.raghvendra;

import java.util.Arrays;

public class RotateArray {
//    public void rotate(int[] nums, int k) {
//        k = k % nums.length;
//        int i = 0, j = ;
//        while()
//    }

    /*
    Second Approach : Reverse entire array, then swap element around the k (within themselves), keeping k as like pivot
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        for(int i = 0, j=nums.length-1; i < j; ++i,j--){
            swap(nums,i,j);
        }
        int pivot = k;
        int firstStart = 0, firstEnd = pivot-1;
        int secondStart = pivot, secondEnd = nums.length-1;
        while(firstStart <= firstEnd){
            swap(nums,firstStart,firstEnd);
            firstStart++;
            firstEnd--;
        }
        while(secondStart < secondEnd){
            swap(nums,secondStart,secondEnd);
            secondStart++;
            secondEnd--;
        }
        System.out.println("Resultant Array: "+ Arrays.toString(nums));
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
