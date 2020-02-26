package com.raghvendra;

import java.util.Arrays;

//-4,-1,0,3,10

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] A) {
        for(int i = 0; i <A.length; ++i){
            int sq = square(A[i]);
            A[i] = sq;
        }
        Arrays.sort(A);
//        System.out.println("Array: "+ Arrays.toString(A));
        return A;
    }

    private int square(int num){
        return num * num;
    }
}
