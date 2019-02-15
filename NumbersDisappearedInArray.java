package com.raghvendra;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NumbersDisappearedInArray {
    /*
    Approach1: Taking extra Space
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> numbers = new HashSet<>();
        for(int i : nums) {
            numbers.add(i);
        }
        for(int i = 1 ; i<=nums.length; i++){
            if(!numbers.contains(i)){
                res.add(i);
            }
        }
        return res;
    }

    /*
    Second Approach: without using any extra Space
     */

//    public List<Integer> findDisappearedNumbers(int[] nums) {
//        List<Integer> res = new ArrayList<>();
//        for(int i = 0; i < nums.length; i++) {
//            int val = Math.abs(nums[i]) - 1;
//            if(nums[val] > 0) {
//                nums[val] = -nums[val];
//            }
//        }
//        System.out.println("Array:"+ Arrays.toString(nums));
//        for(int i = 0; i < nums.length; i++) {
//            if(nums[i] > 0) {
//                res.add(i+1);
//            }
//        }
//        return res;
//    }

}


