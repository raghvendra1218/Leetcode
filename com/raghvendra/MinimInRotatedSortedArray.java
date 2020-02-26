package com.raghvendra;

public class MinimInRotatedSortedArray {
    public int findMin(int[] nums) {
        //Brute Force
//        int min = nums[0];
//        for(int i = 1; i<nums.length;++i){
//            if(nums[i] < min){
//                min = nums[i];
//            }
//        }
//        return min;
        //Binary Search tree version
        if(nums.length == 1)return nums[0];
        int left = 0;
        int right = nums.length -1;
        if(nums[0] < nums[right]) return nums[0];

        while(right >= left){
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if(nums[mid] < nums[mid - 1]) return nums[mid];
            if(nums[mid] > nums[0]){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
