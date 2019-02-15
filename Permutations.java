package com.raghvendra;

import java.util.*;
import java.util.stream.Collectors;

public class Permutations {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> numAsArray = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());
        Set<Integer> set = new HashSet<>(numAsArray);
        recursion(set, list);
        return result;
    }
    public void recursion (Set<Integer> set, List<Integer> num){
        if(set.isEmpty()){
            result.add(num);
            return;
        }
        for(int n: set){
            num.add(n);
            List<Integer> newList = new ArrayList<>(num);
            Set<Integer> newSet = new HashSet<>(set);
            newSet.remove(n);
            recursion(newSet, newList);
        }
    }
}
