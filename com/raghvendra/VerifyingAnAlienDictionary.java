package com.raghvendra;

/**
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
 * The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet,
 * return true if and only if the given words are sorted lexicographicaly in this alien language.
 *
 * Example 1:
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 *
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * Example 3:
 *
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.)
 * According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 *
 * Constraints:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are English lowercase letters.
 */

public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        //Create the order map as per the order string
        int[] alphabetMap = new int[26];
        for (int i = 0; i < order.length(); ++i) {
            alphabetMap[order.charAt(i) - 'a'] = i;
        }
        //Compare word by word and sort them according to the order
        for(int i = 0; i < words.length; ++i) {
            for(int j = i + 1; j < words.length; ++j) {
                //Comparison should be done on the minimum of the two lengths of the word
                int min = Math.min(words[i].length(), words[j].length());
                for(int k = 0; k < min; ++k) {
                    char iChar = words[i].charAt(k);
                    char jChar = words[j].charAt(k);
                    //conditions for the comparision
                    //condition 1: if value of iChar is less than jChar then break and compare next char.
                    //condition 2: if the value of the iChar is greater than jChar then we can safely return false
                    //condition 3: if the length of the word at the ith position is greater than the word at the jth position and till now the comparision of the character has been same in both words then we can safely return false
                    if(alphabetMap[iChar - 'a'] < alphabetMap[jChar - 'a']) {
                        break;
                    } else if(alphabetMap[iChar - 'a'] > alphabetMap[jChar - 'a']) {
                        return false;
                    } else if(k == min - 1 && words[i].length() > words[j].length()){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
