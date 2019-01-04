package com.raghvendra;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int [] nums = {9, 7, 8};
        //AtleastTwiceInArray
//        AtleastTwiceInArray a = new AtleastTwiceInArray();
//        int index = a.dominantIndex(nums);
//        System.out.println("Dominant Index is : " + index);
        //PivotIndex
//        PivotIndex p = new PivotIndex();
//        int index = p.pivotIndex(nums);
//        System.out.println("Pivot Index is : " + index);
        //PlusOne
        PlusOne p = new PlusOne();
        int[] resultantArray = p.plusOne(nums);
        System.out.println("ResultantArray: " + Arrays.toString(resultantArray));
    }
}
