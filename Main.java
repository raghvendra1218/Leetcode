package com.raghvendra;

import java.util.Arrays;

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
//          PascalTriangle p = new PascalTriangle();
//          List<List<Integer>> resultantList = new ArrayList<List<Integer>>();
//          resultantList = p.generatePascal(5);
//          for(List<Integer> L : resultantList) {
//              List<Integer> a = new ArrayList<Integer>();
//              for ( a : L) {
//                  System.out.println("Resultant List is :" + a);
//              }
//          }
//        for(int i = 0; i<resultantList.size(); i++) {
//            for( int j = 0 ; j<resultantList.get(i).size(); j++ ) {
//                System.out.print(resultantList.get(i).get(j));
//            }
//            System.out.println();
//        }
        //StairCase Problem:
//        StaircaseProblem staircaseProblem = new StaircaseProblem();
//        System.out.println("Number of ways for N with recursive approach = 4: "+ staircaseProblem.num_ways_recursive(4));
        //Dynamic Programming approach:
//        System.out.println("Number of ways for N = 4: with Dynamic Programming "+ staircaseProblem.num_ways_bottom_up(4));
        // TwoSum
//        int [] nums = {3,2,4};
//        TwoSum twoSum = new TwoSum();
//        int[] result = twoSum.twoSum(nums,6);
//        System.out.println("Resultant array: "+ Arrays.toString(result));
        //Reverse String
        char[] s = {'h','e','l','l','o'};
//        char[] s = {'H','a','n','n','a','h};
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(s);
        System.out.println("Resultant Array: "+ Arrays.toString(s));
    }
}
