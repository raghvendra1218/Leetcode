package com.raghvendra;

import java.util.ArrayList;
import java.util.List;

/**
 * Can be done using brute force, where we can fix one element in the outer element and in second loop we
 * can check if the fixed elements exist in the rest of teh array
 * Time Complexity : O(N^2)
 * Space Complexity: O(1)
 */

/**
 *Can be done using Sorting the Array
 * Time Complexity : O(NlogN)
 * Space Complexity : O(1)
 */

/**
 * Can be done using Set
 * Time Complexity : O(N)
 * Space Complexity: O(N)
 */

/**
 * Can be done using Encoding
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * Intuition : 0 <=x <=len(array-1), we can use this info to mark the element as visited on the index, if the value we are traversing through
 * the array gives the same index value it means that the value at teh point is duplicate
 * Since numbers are natural numbers, so we in order to find the index and flipping the value of that index we will subtract 1 from teh value
 * at that index to get the actual index of array
 */

public class FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; ++i){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0){
                result.add(index + 1);
            } else {
                nums[index] = -nums[index];
            }
        }
        return result;
    }
}
