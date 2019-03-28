package com.raghvendra;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList =  new ArrayList<>();
        int start  = 0;
//        Arrays.sort(nums);
        backTrack(result, tempList, start, nums);
        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> tempList, int start, int[] nums){
        result.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; ++i){
            tempList.add(nums[i]);
            backTrack(result, tempList, i + 1, nums);
            tempList.remove(tempList.size() - 1);
        }
    }
}
