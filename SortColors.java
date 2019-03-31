package com.raghvendra;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 *
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */


/**
 * Intuition -  Take three pointers for keeping track of three different colors marked as 0,1,2
 * left pointer keeps the tack for zero, and is advanced only if the zero is encountered, along with it m is also advanced
 * mid pinter is to keep the track for 1 elements and it's responsibility is to segregate them
 * right pointer - is to keep the track for the 2 elements in array and is decremented when 2 is met
 */

public class SortColors {
    public void sortColors(int[] nums) {
        //initialise the pointer value with their index values
        int left = 0, mid = 0, right = nums.length -1;
        //Traverse through array till mid is less than or equal to right pointer
        while(mid <= right){
            //If 2 then swap the element at mid with the element at right pointer and decrement right pointer by 1
            if(nums[mid] == 2){
                swap(nums, mid, right);
                right--;
            }
            //If 0 then swap the element at mid with the element at the left pointer and increment left and mid pointer by 1
            else if(nums[mid] == 0){
                swap(nums,mid,left);
                mid++;
                left++;
            }
            //If 1 then simply increment the mid pointer
            else {
                mid++;
            }
        }
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
