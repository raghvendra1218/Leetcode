package com.raghvendra;

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
//        char[] s = {'h','e','l','l','o'};
////        char[] s = {'H','a','n','n','a','h};
//        ReverseString reverseString = new ReverseString();
//        reverseString.reverseString(s);
//        System.out.println("Resultant Array: "+ Arrays.toString(s));
        //Reverse Words In a String
//        String s = "the sky is   blue";
//        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
//        String resultantString = reverseWordsInAString.reverseWords(s);
//        System.out.println("Resultant String : "+ resultantString);
        //String to Integer
//        String s = " ";
//        StringToInteger stringToInteger = new StringToInteger();
//        System.out.println("Result:"+ stringToInteger.myAtoi(s));
        //Valid Palindrome
//        String s = "A man, a plan, a canal: Panama";
//        ValidPalindrome vp = new ValidPalindrome();
//        System.out.println(vp.isPalindrome(s) ? "Sentence is a Palindrome" : "Sentence is not a Palindrome");
        //Reverse Integer
//        int a = 578;
//        ReverseInteger ri = new ReverseInteger();
//        System.out.println("Reversed integer: "+ ri.reverse(a));
        //Valid Parentheses
//        String str = "]";
//        ValidParentheses validParentheses = new ValidParentheses();
//        System.out.println("String is Valid Parentheses: "+ validParentheses.isValid(str));
        //Tower of Hanoi
//        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
//        towerOfHanoi.towerOfHanoi(3,'A','C','B');
        //Array in sorted order with Recursion
//        int[] A = {1,2,3,4,5,6};
//        ArrayInSortedOrderWithRecursion AISOR  = new ArrayInSortedOrderWithRecursion();
//        System.out.println(AISOR.isArraySortedOrder(A,5));
        //Sum of Two Strings
//        String s1 = "823456789";
//        String s2 = "823456789";
//        SumTwoStrings sumTwoStrings = new SumTwoStrings();
//        System.out.println(sumTwoStrings.sum(s1,s2));
        //Single Number
//        int[] nums = {1,3,1,-1,3};
//        SingleNumber singleNumber= new SingleNumber();
//        System.out.println(singleNumber.singleNumber(nums));
        //Remove Duplicates from Sorted Array
//        int [] nums = {-3,-1,0,0,0,3,3};
//        RemoveDuplicatesSortedArray removeDuplicatesSortedArray = new RemoveDuplicatesSortedArray();
//        System.out.println("Size: "+ removeDuplicatesSortedArray.removeDuplicates(nums));
        //Squares of a Sorted Array
//        int[] A = {-4,-1,0,3,10};
//        SquaresOfSortedArray squaresOfSortedArray = new SquaresOfSortedArray();
//        squaresOfSortedArray.sortedSquares(A);
        //Move Zeros
//        int[] nums = {2,1,0,9,8,0,7,1};
//        MoveZeros moveZeros = new MoveZeros();
//        moveZeros.moveZeroes(nums);
        //Maximum Subarray
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        MaximumSubarray maximumSubarray = new MaximumSubarray();
//        System.out.println("Resultant maximum Sum of Subarray:  "+maximumSubarray.maxSubArray(nums));
        //Missing Number
        int[] nums = {9,6,4,2,3,5,7,0,1};
        MissingNumber missingNumber = new MissingNumber();
        System.out.println("Missing Number: "+ missingNumber.missingNumber(nums));
    }
}
