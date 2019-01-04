package com.raghvendra;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int [] nums = {1, 7, 3, 6, 5, 6};
        //AtleastTwiceInArray
//        AtleastTwiceInArray a = new AtleastTwiceInArray();
//        int index = a.dominantIndex(nums);
        //PivotIndex
        PivotIndex p = new PivotIndex();
        int index = p.pivotIndex(nums);
        System.out.println("Dominant Index is : " + index);
    }
}
