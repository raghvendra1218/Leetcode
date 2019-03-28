package com.raghvendra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        //required in order the condition check which we are using nums[i] == nums[i - 1] to be valid
        Arrays.sort(nums);
        int start  = 0;
        backTrack(result, tempList, start, nums);
        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> tempList, int start, int[] nums){
        result.add(new ArrayList<>(tempList));

        for(int i = start; i < nums.length; ++i){
            if(i > start && nums[i] == nums[i - 1]) continue;  //skip Duplicates
            tempList.add(nums[i]);
            backTrack(result, tempList, i + 1, nums);
            tempList.remove(tempList.size() - 1);
        }
    }
}
