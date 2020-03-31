package com.raghvendra;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines;
 * otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */

public class RansomNote {
    /**
     * Approach 1: Create two arrays of 26 size both for magazine and ransom note characters.
     *            Keep the count of characters in these arrays and then compare both of them.
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int [] magazineNoteLetterMap = createLetterMapArray(magazine);
        int [] ransomNoteLetterMap = createLetterMapArray(ransomNote);

        //compare the values of the ransomLetterMap in magazineNoteLetterMap, the values in magazineNoteLetterMap should
        //be greater than or equal to the values in the ransomLetterMap
        for(int i = 0 ; i < ransomNoteLetterMap.length; i++) {

            //check if the values at the index of the magazineNoteLetterMap is always greater than ransomNoteLetterMap, if not return false
            if(ransomNoteLetterMap[i] > 0 && ransomNoteLetterMap[i] > magazineNoteLetterMap[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] createLetterMapArray(String S) {
        int[] characterMap = new int [26];

        //traverse through string and increase the value at the respective index in characterMap
        for (char c : S.toCharArray()) {
            characterMap[c - 'a']++;
        }
        return characterMap;
    }
}
