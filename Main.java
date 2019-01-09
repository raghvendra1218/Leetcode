package com.raghvendra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        int [] nums = {9, 7, 8};
        //AtleastTwiceInArray
//        AtleastTwiceInArray a = new AtleastTwiceInArray();
//        int index = a.dominantIndex(nums);
//        System.out.println("Dominant Index is : " + index);
        //PivotIndex
//        PivotIndex p = new PivotIndex();
//        int index = p.pivotIndex(nums);
//        System.out.println("Pivot Index is : " + index);
        //PlusOne
//        PlusOne p = new PlusOne();
//        int[] resultantArray = p.plusOne(nums);
//        System.out.println("ResultantArray: " + Arrays.toString(resultantArray));
        //PascalTriangle
          PascalTriangle p = new PascalTriangle();
          List<List<Integer>> resultantList = new ArrayList<List<Integer>>();
          resultantList = p.generatePascal(5);
//          for(List<Integer> L : resultantList) {
//              List<Integer> a = new ArrayList<Integer>();
//              for ( a : L) {
//                  System.out.println("Resultant List is :" + a);
//              }
//          }
        for(int i = 0; i<resultantList.size(); i++) {
            for( int j = 0 ; j<resultantList.get(i).size(); j++ ) {
                System.out.print(resultantList.get(i).get(j));
            }
            System.out.println();
        }

    }
}
