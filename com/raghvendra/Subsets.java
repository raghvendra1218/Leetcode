package com.raghvendra;
/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */

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
