package com.raghvendra;

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
