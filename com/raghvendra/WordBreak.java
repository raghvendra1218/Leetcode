package com.raghvendra;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 */

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int len = s.length();
        //create an array to store the value as true for the indexes in the String for which word is present in the wordDict
        boolean [] dp = new boolean[len + 1];
        //Initialise the first element in the dp array as true
        dp[0] = true;
        for(int i = 0; i < len; ++i){
            for(int j = 0; j <= i; ++j){
                //Check for the word from index to index, for those index where dp[j] is true we can check the word following it is present in
                //worDict or not, if yes then we will mark the end of the index as dp[j] equal to true;
                if(dp[j]){
                    if(set.contains(s.substring(j, i + 1))){
                        dp[i + 1] = true;
                    }
                }
            }
        }
        System.out.println("DP Array: "+ Arrays.toString(dp));
        return dp[len];
    }
}
