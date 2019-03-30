package com.raghvendra;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 *
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */

public class TwoSumII {
    /**
        Approach 1: Using HashMap
     */
//    public int[] twoSum(int[] numbers, int target) {  //2,7,11,15 , target : 9
//        Map<Integer,Integer> myMap =  new HashMap<>();
//        int[] result = new int[2];
//        for(int i = 0; i < numbers.length;i++){
//            result[1] = i;
//            if(myMap.containsKey(target - numbers[i])){
//                result[0] = myMap.get(target - numbers[i]);
//                result[0] = result[0]+1;
//                result[1] = result[1]+1;
//                return result;
//            } else {
//                myMap.put(numbers[i],i);
//            }
//        }
//        return result;
//    }

    /**
        Second Approach : Two pointer
     Intuition : If target is greater than nums[start] + nums[end] , decrement the end pointer and continue.
                 If target is smaller than nums[start] + nums[end], increment the start pointer and continue.
                 For each iteration check if nums[start] + nums[end] == target.
     */

    public int[] twoSum(int[] numbers, int target) {  //2,7,11,15 , target : 9
        int  i = 0, j = numbers.length -1;;
        int[] result = new int[2];
        while(numbers[i] + numbers[j] != target){
            while(numbers[i] + numbers[j] < target){
                i++;
            }
            while(numbers[i] + numbers[j] > target){
                j--;
            }
        }
        result[0] = i+1;
        result[1] = j+1;
        return result;
    }
}
