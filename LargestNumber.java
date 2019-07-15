package com.raghvendra;

import java.util.Arrays;
import java.util.Comparator;


/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 *
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] string_num =  new String[nums.length];

        //Convert the numbers in nums array to string form
        for(int i = 0; i < nums.length; ++i){
            string_num[i] = String.valueOf(nums[i]);
        }

        //Write the comparator to add the strings and return the maximum value formed
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) { //{3,30,....}
                String s1 = o1 + o2; //330
                String s2 = o2 + o1; //303
                return s2.compareTo(s1); //Arrays will be in sorted in reverse order, we can later append it
            }
        };

        //Now sort the entire string_num using above defined comparator
        Arrays.sort(string_num, comparator);
        // Since array is sorted in reverse order, we can check the special case when all the elements are zero in
        // the nums array we don't want our answer as "00000" rather we want single 0, we will just check the first element in the
        // string_num if that is zero, it means all the element in the string_num are zero, because largest digit is supposed to
        // store in the zeroth index of string_num
        if(string_num[0].charAt(0) == '0') return "0";


        //Store the answer and append the result to a stringBuilder
        StringBuilder result = new StringBuilder();
        for(String s : string_num){
            result.append(s);
        }
        return result.toString();
    }
}
