package com.raghvendra;

public class ArrayInSortedOrderWithRecursion {
    public int isArraySortedOrder(int[]A, int index){
        if(A.length == 1) return 1;
        return (A[index - 1] < A[index -2]) ? 0 : isArraySortedOrder(A, index-1);
    }
}
