package com.raghvendra;

public class StaircaseProblem {
    public int num_ways_recursive(int n){
        if(n == 1 || n == 0) {
            return 1;
        }
//        } else {
            return num_ways_recursive(n-2) + num_ways_recursive(n-1);
//        }
    }

    public int num_ways_bottom_up(int n){
        if(n == 0 || n == 1){
            return 1;
        } else {
            int[] nums = new int[n+1];
            nums [0] = 1;
            nums[1] = 1;
            for(int i = 2; i<nums.length; i++){
                nums[i] = nums[i-1] + nums[i-2];
            }
            return nums[n];
        }
    }

//    public int num_ways_top
}
