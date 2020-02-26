package com.raghvendra;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

/*    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
// Brute Force Approach, Complexity O(n^2)
        for(int i = 0; i < nums.length; i++) {
            int firstNum = nums[i];
            int firstNumIndex = i;
            result[0] = i;
            int secondNum = target - nums[i];
            if(secondNum > 0) {
                for(int j = i+1; j < nums.length; j++){
                    int secondNumIndex = j;
                    if(secondNum == nums[j]){
                        secondNumIndex = j;
                        result[1] = j;
                        return result;
                    }
                }
            }
        }*/

    /**
     * Approach : Using two Pass, HashMap
     * @param nums
     * @param target
     * @return
     */

/*        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
        Map<Integer, Integer> myMap = new HashMap<>();
        for( int i = 0; i < nums.length; i++){
            myMap.put(nums[i], i);
        }
        for(int j = 0; j < nums.length; j++){
            int firstNum = nums[j];
            int firstNumIndex = j;
            result[0] = j;
            int secondNum = target - firstNum;
            if(myMap.containsKey(secondNum)) {
                int secondNumIndex = myMap.get(secondNum);
                if(result[0] != secondNumIndex){
                    result[1] = secondNumIndex;
                    return result;
                }
            }
        }
        return result;
    }*/

    /**
     * One Pass Solution, using HashMap
     * Intuition :
     * It turns out we can do it in one-pass. While we iterate and insert elements into the table,
     * we also look back to check if current element's complement already exists in the table.
     * If it exists, we have found a solution and return immediately.
     */

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
