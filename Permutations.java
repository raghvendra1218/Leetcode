package com.raghvendra;


import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permutations(nums, 0, result);
        return result;
    }

    private void permutations(int[] nums, int start, List<List<Integer>> result){
        if (start >= nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int i : nums){
                temp.add(i);
            }
            result.add(temp);
        }

        for(int i = start; i <nums.length; ++i){
            swap(nums, start, i);
            permutations(nums, start + 1 , result);
            swap(nums, start,i);
        }
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
