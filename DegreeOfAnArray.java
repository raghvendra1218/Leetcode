package com.raghvendra;

import java.util.HashMap;
import java.util.Map;

/*

Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:
Input: [1, 2, 2, 3, 1]
Output: 2
Explanation:
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:
Input: [1,2,2,3,1,4,2]
Output: 6
Note:

nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.
 */
public class DegreeOfAnArray {
    private class Details {
        int startIndex = 0;
        int endIndex = 0;
        int count = 0;
        Details(int startIndex){
            this.startIndex = startIndex;
            this.endIndex = startIndex;
            this.count = 0;
        }
    }

    public int findShortestSubArray(int[] nums) {
        int ans = Integer.MAX_VALUE;
        Map<Integer, Details> myMap =  new HashMap<>();
        for(int i = 0; i < nums.length; ++i){
            if(myMap.containsKey(nums[i])){
                Details tempdt = myMap.get(nums[i]);
                tempdt.count +=1;
                tempdt.endIndex = i;
                myMap.put(nums[i], tempdt);
            } else {
                Details dt = new Details(i);
                myMap.put(nums[i], dt);
            }
        }
        int maxCount = 0;
       for(Map.Entry<Integer, Details> entry : myMap.entrySet()){
           Details dt = entry.getValue();
           if(dt.count >= maxCount){
               maxCount = dt.count;
           }
       }
        for(Map.Entry<Integer, Details> entry : myMap.entrySet()){
            Details dt = entry.getValue();
            if(dt.count == maxCount){
                int tempAns = dt.endIndex - dt.startIndex + 1;
                if(tempAns < ans){
                    ans = tempAns;
                }
            }
        }
        return ans;
    }
}
