package com.raghvendra;

/**
 * Source : https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        //Edge case
        if(s == null || s.length() == 0) return new ArrayList<>();

        List<List<String>> result = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        backtrack(s, result, tempList);
        return result;
    }

    private void backtrack(String s, List<List<String>> result, List<String> tempList){
        //Base Case
        if(s == null || s.length()== 0){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = 1; i<= s.length(); ++i){
            String temp = s.substring(0,i);
            if(!checkPalindrome(temp)) continue;
            tempList.add(temp);
            backtrack(s.substring(i, s.length()),result,tempList);
            tempList.remove(tempList.size() - 1);
        }
        return;
    }

    private boolean checkPalindrome(String s){
        int start = 0;
        int end = s.length() - 1;
        while (start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
