package com.raghvendra;

/**
 * Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a==c and b==d), or
 * (a==d and b==c) - that is, one domino can be rotated to be equal to another domino.
 *
 * Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].
 *
 * Example 1:
 *
 * Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 */

/**
 * Approach 1:  Brute Force, Time Limit exceed
 *              Iterate through each element in domino and perform addition and subtraction to
 *              identify each domino
 */
/*public class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int dominoLen = dominoes.length;
        int countPairs = 0;

        for(int i = 0; i < dominoLen; ++i){
            //Idea being no two pair can have same values for sum and diff within themselves
            int sumFirst = dominoes[i][0] + dominoes[i][1];
            int diffFirst = Math.abs(dominoes[i][0] - dominoes[i][1]);

            //Iterate rest of the length to find the similar pair, with elements swapped within themselves
            for(int j = 0; j < dominoLen; j++){
                int sumSecond = dominoes[j][0] + dominoes[j][1];
                int diffSecond = Math.abs(dominoes[j][0] - dominoes[j][0]);
                //If the pair is found increase the countPair
                if(sumFirst == sumSecond && diffFirst == diffSecond){
                    countPairs++
                }
            }
        }
        return countPairs;
    }
}*/

import java.util.HashMap;
import java.util.Map;

/** Approach 2: We need to find a way to make a unique key to store all the pairs.
 *              Idea being same key for the same set of pair in HashMap
 */

public class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        int countPairs = 0;

        for(int[] d : dominoes){
            //Extract the min and the max value, and create the key by making a tendigit number out of it
            int min = Math.min(d[0], d[1]);
            int max = Math.max(d[0], d[1]);

            //This key will generate the same key for same pair
            int key = min * 10 + max;

            //Map will either return the value present or will return default value as 0
            int pairs = map.getOrDefault(key, 0);
            countPairs += pairs;
            //We are adding the key, value later in map , because we don't want to increase the countPair for it's single existence
            map.put(key, 1 + pairs);
        }
        return countPairs;
    }
}
