package com.raghvendra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || nums[i] != nums[i-1]){
                int start = i + 1;
                int end = nums.length - 1;
                while(start < end){
                    if(nums[i] + nums[start] + nums[end] == 0){
                        result.add(new ArrayList<>(Arrays.asList(nums[i],nums[start],nums[end])));
                    }

                    if(nums[i] + nums[start] + nums[end] < 0) {
                        int currentStart = start;
                        while(nums[currentStart] == nums[start] && start < end){
                            start++;
                        }
                    }

                    else {
                        int currentEnd = end;
                        while(nums[currentEnd] == nums[end] && start < end){
                            end--;
                        }
                    }
                }
            }
        }
        return result;
    }
}
