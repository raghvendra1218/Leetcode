package com.raghvendra;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int maxLength = 0;
        Set<Character> mySet =  new HashSet<>();
        while(j < s.length()){
            if(!mySet.contains(s.charAt(j))){
                mySet.add(s.charAt(j));
                j++;
                maxLength = Math.max(maxLength, j - i);
            } else {
                mySet.remove(s.charAt(i));
                i++;
            }
        }
        return maxLength;
    }
}
