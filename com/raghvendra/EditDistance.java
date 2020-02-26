package com.raghvendra;
/*
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 */

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] map = new int[word1.length() + 1][word2.length() + 1];

        //initialize the first row and col for the map matrix
        for(int i = 0; i < map.length; ++i){
            map[i][0] = i;
        }

        for(int j = 0; j < map[0].length; ++j){
            map[0][j] = j;
        }

        //Traverse through the WordMap and fill the co-ordinates with minimum of all the three above operations
        for(int i = 1; i <= word1.length() ; ++i){
            for(int j = 1; j <= word2.length(); ++j){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    map[i][j] = map[i - 1] [j - 1];
                } else {
                    map[i][j] = 1 + Math.min(Math.min(map[i-1][j-1],map[i-1][j]), map[i][j-1]);
                }
            }
        }
        return map[word1.length()][word2.length()];
    }
}
