package com.raghvendra;
/*
Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
 */

import java.util.ArrayList;
import java.util.List;

public class ShuffleAnArray {
    //Create member variables required at class level
    private int[] nums;

    //Constructor to instantiate the objects
    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] resultArray = new int[this.nums.length];
        List<Integer> tempArrayList = new ArrayList<>();
        for(int n : nums){
            tempArrayList.add(n);
        }
        int counter = 0;
        while(counter < nums.length){
            int min = 0;
            int max = tempArrayList.size() - 1;
            int rand = (int)(Math.random()*((max-min)+1))+min;
            resultArray[counter] = tempArrayList.get(rand);
            tempArrayList.remove(rand);
            counter ++;
        }
        return resultArray;
    }

    /**
     * Approach 2 :
     */
}
