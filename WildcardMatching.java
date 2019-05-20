package com.raghvendra;

/*
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false
 */

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        char [] str = s.toCharArray();
        char [] pattern = p.toCharArray();

        //Convert multiple contiguous "****"  to one "*" in pattern char array
        int waitingIndex = 0;
        boolean firstStar = true;
        for(int i = 0; i < pattern.length; ++i){
            if(pattern[i] == '*'){
                if(firstStar){
                    pattern[waitingIndex] = pattern[i];
                    waitingIndex++;
                    firstStar = false;
                }
            } else {
                pattern[waitingIndex] = pattern[i];
                waitingIndex++;
                firstStar = true;
            }
        }

        //Define a new 2-D char array
        boolean [][] T = new boolean[s.length() + 1][waitingIndex + 1];

        //Initialise the zeorth row and col as True, because if str = "" and pattern = "" , it's a clear match
        T[0][0] = true;

        //Boundary condition when pattern's zeroth index is a "*", in that case T[0][1] will be equal to True
        if(waitingIndex > 0 && pattern[0] == '*'){
            T[0][1] = true;
        }

        //Iterate through the string and pattern and fill the values in the T matrix
        for(int i = 1; i < T.length; ++i){
            for(int j = 1; j < T[0].length; ++j){
                if(pattern[j - 1] == '?' || str[i - 1] == pattern[j - 1]){
                    T[i][j] = T[i - 1][j - 1];
                } else if(pattern[j - 1] == '*'){
                    T[i][j] = T[i - 1][j] || T[i][j - 1];
                }
            }
        }
        return T[str.length][waitingIndex];
    }
}
