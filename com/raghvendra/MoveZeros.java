package com.raghvendra;

import java.util.Arrays;

public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while(j < nums.length){
            if(i == j && nums[j] !=0){
                i++;
            } else if(nums[j] !=0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
            j++;
        }
        System.out.println("Resultant Array: "+ Arrays.toString(nums));
    }
}
