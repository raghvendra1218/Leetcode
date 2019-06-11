package com.raghvendra;

import java.util.Arrays;

//3,4,6,2,1,8,9

public class ZigZagArray {
    public void makeZigZag(int[] nums){
        boolean flag = true;
        //Keep the first element as it is, becoz we cannot compare the first element with it's precceding element
        int i = 0;
        while(i < nums.length - 1){
            if(flag){
                if(nums[i] > nums[i + 1]){
                    swap(nums, i, i + 1);
                }
            } else {
                if(nums[i] < nums[i + 1]){
                    swap(nums, i, i + 1);
                }
            }
            i++;
            flag = !flag;
        }
        System.out.println(Arrays.toString(nums));
    }

    private void swap (int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
