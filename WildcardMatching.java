package com.raghvendra;

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
