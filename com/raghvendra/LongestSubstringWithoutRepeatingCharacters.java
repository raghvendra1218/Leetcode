package com.raghvendra;
/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int maxLength = 0;
        Set<Character> mySet =  new HashSet<>();
        while(j < s.length()){
            if(!mySet.contains(s.charAt(j))){
                mySet.add(s.charAt(j));
                maxLength = Math.max(maxLength, j - i);
                j++;
            } else {
                mySet.remove(s.charAt(i));
                i++;
            }
        }
        return maxLength;
    }
}
