package com.raghvendra;

/**
 * Intuition -  Take three pointers for keeping track of three different colors marked as 0,1,2
 * left pointer keeps the tack for zero, and is advanced only if the zero is encountered, along with it m is also advanced
 * mid pinter is to keep the track for 1 elements and it's responsibility is to segregate them
 * right pointer - is to keep teh track for the 2 elements in array and is decremented when 2 is met
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
