package com.raghvendra;

/*
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
 */


public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        char[] pattern = p.toCharArray();
        char[] text = s.toCharArray();
        boolean[][] T = new boolean[text.length + 1][pattern.length + 1];

        //initialise the zeroth row and col value as True, because the empty pattern and empty text is a match
        T[0][0] = true;
        //Handle patterns like : *a , a*b*, a*b*c* , in this case the first row will be True
        for(int i = 1; i < T[0].length; ++i){
            if(pattern[i - 1] == '*'){
                T[0][i] = T[0][i - 2];
            }
        }

        for(int i = 1; i < T.length; ++i){
            for(int j = 1; j < T[0].length; ++j){
                //When the character in the string and the pattern matches,
                //then we will remove both and check by removing those whether the rest of the text and pattern matches or not, we will get that
                //from the T[i-1][j-1] cell
                if(pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]){
                    T[i][j] = T[i - 1][j - 1];
                } else if(pattern[j - 1] == '*'){
                    //We will check zero occurrence of the character
                    T[i][j] = T[i][j - 2];
                    //We will check if the pattern at j - 2 is '.' or if the character at j -2 matches with the text's current character
                    if(pattern[j - 2] == '.' || pattern[j - 2] == text[i - 1]){
                        T[i][j] = T[i][j] || T[i - 1][j];
                    }
                } else{
                    T[i][j] =  false;
                }
            }
        }
        return T[text.length][pattern.length];
    }
}
