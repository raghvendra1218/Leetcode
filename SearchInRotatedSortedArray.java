package com.raghvendra;

/**
 * Intuition : First find the point of Inflection/Pivot and then apply the Binary search on two sorted arrays
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        //check for the empty and when the length of array is one
        if(nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;

        //initialise the initial variables which needs to be passed
        int result = 0;
        int start = 0;
        int end = nums.length - 1;

        //if array is sorted, no need to find the point of inflection, this will occur when the array has been rotated by nums.length times
        //try this rotation on pen and copy and you will understand what I am trying to say.
        if(nums[start] < nums[end]){
            //Just do the simple binary search on the sorted array
            result = binarySearch(start, end, nums, target);
        } else {
            //Find the point of Inflection/Pivot
            int index = findPivot(start, end, nums);

            //check in which sorted array does our target may lie
            if(target >= nums[index] && target <= nums[end]){
                result = binarySearch(index, end, nums, target);
            } else {
                //lies in the left sorted of the inflection
                result  = binarySearch(start, index - 1, nums, target);
            }
        }
        return result;
    }

    int foundIndex = 0;
    private int findPivot(int start, int end, int[] nums){
        int mid = start + (end - start)/2;
        //Base case for recursion
        if(nums[mid] > nums[mid + 1]){
            return mid + 1;
        } else {
            if(nums[start] > nums[mid]){
                foundIndex = findPivot(start, mid - 1, nums);
            } else {
                foundIndex = findPivot(mid + 1, end, nums);
            }
        }
        return foundIndex;
    }

    private int binarySearch(int start, int end, int[] nums, int target) {
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target) {
                return mid;
            } else {
                if(nums[mid] > target){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
