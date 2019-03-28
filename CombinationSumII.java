package com.raghvendra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        //required in order the condition check which we are using candidates[i] == candidates[i - 1] to be valid
        Arrays.sort(candidates);
        int start = 0;
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
            for (int i = start; i < candidates.length; ++i){
                if(i > start && candidates[i] == candidates [i - 1]) continue;
                tempList.add(candidates[i]);
                backTrack(result, tempList, i + 1, remain - candidates[i], candidates);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
