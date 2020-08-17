package com.raghvendra;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 *
 *
 * Example 1:
 *
 * Input: "USA"
 * Output: True
 *
 *
 * Example 2:
 *
 * Input: "FlaG"
 * Output: False
 */

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        //Order in which the conditions are written here is important,
        //The last condition should be at last and it cannot come in between or in front of the above two conditions.
        //While the above two conditions can be inter-changed, the result will be same.
        if(word.toLowerCase().equals(word)) {
            return true;
        }
        if (word.toUpperCase().equals(word)) {
            return true;
        }
        //Check if upon doing the uppercase of the first character matches with the first character of the given string.
        //Rest check if doing the lowercase of the following string matches with the rest of the following string of given word.
        return word.substring(0, 1).toUpperCase().equals(word.substring(0, 1)) && word.substring(1).toLowerCase().equals(word.substring(1));
    }
}
