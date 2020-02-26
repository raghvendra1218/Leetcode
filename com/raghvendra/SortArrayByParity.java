package com.raghvendra;

public class SortArrayByParity {
//    public int[] sortArrayByParity(int[] A) {
//        int start = 0, end = A.length-1;
//        int[] B = new int[A.length];
//        int startIndex = 0, endIndex = A.length-1;
//        while(start < end){
//            if(A[start]%2 == 0){
//                B[startIndex] = A[start];
//                startIndex++;
//            } else {
//                B[endIndex] = A[start];
//                endIndex --;
//            }
//            start++;
//        }
//        return B;
//    }

    /*
    Second Approach : O(1) Space
     */

    public int[] sortArrayByParity(int[] A) {
        int start = 0, end = A.length-1;
        while(start < end){
            if(A[start]%2 == 0){
                start++;
                continue;
            }
            if(A[end]%2 !=0){
                end --;
                continue;
            }
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
        }
        return A;
    }
}
