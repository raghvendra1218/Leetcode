package com.raghvendra;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        int remain = n;
        int start = 1;
        backTrack(result, tempList, remain, k, start);
        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> tempList, int remain, int k, int start){
        if(remain < 0){
            return;
        } else if (remain == 0 && tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
        } else {
            for(int i = start; i <= 9; ++i){
//                if(tempList.size() < k){
                    tempList.add(i);
                    backTrack(result, tempList, remain - i, k, i + 1);
                    tempList.remove(tempList.size() - 1);
//                }
            }
        }
    }
}
