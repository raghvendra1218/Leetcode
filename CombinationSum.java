package com.raghvendra;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        //Arrays.sort(candidates); // we can avoid sorting as it's mentioned in the question that candidates numbers will distinct
        int start  = 0;
        int remain = target;
        backTrack(result, tempList, start, remain, candidates);
        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> tempList, int start, int remain, int[] candidates){
        if(remain < 0){
            return;
        } else if(remain == 0){
            result.add(new ArrayList<>(tempList));
        } else {
            for(int i = start; i < candidates.length; ++i){
                if(i > start && candidates[i] == candidates[i - 1]) continue;
                tempList.add(candidates[i]);
                backTrack(result, tempList, i, remain - candidates[i], candidates);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
