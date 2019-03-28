package com.raghvendra;


import java.util.ArrayList;
import java.util.List;

/**
 * Approach 1: Not including the element from the list if already exist
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backTrack(result, tempList, nums);
        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if(tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        }

        for(int i = 0; i < nums.length; ++i){
            if(tempList.contains(nums[i])) continue;
            tempList.add(nums[i]);
            backTrack(result, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }
}



/**
 * Approach 2: Using swap and progressing index on each iteration
 */
/*public class Permutations {
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
}*/
