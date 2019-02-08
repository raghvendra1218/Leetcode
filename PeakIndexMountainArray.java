package com.raghvendra;

public class PeakIndexMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        int right = A.length -1;
        int left = 0;
        int index = 0;
        int output = A[0];
        while(left <= right){
            if(A[left] > output){
                output = A[left];
                index = left;
            }
            if(A[right] > output){
                output = A[right];
                index = right;
            }
            left++;
            right--;
        }
        return index;
    }
}
