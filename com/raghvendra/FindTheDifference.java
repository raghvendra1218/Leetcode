package com.raghvendra;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int[] charMapS = new int[128];
        for (int i = 0; i < s.length(); ++i) {
            charMapS[s.charAt(i) - 'a']++;
        }

        // Iterate over the string t and decrease the counter as we go through the string t each character
        // we have a solution when the value at the index for charMap is less then 1
        char x = ';';
        int pos;
        for (int i = 0; i < t.length(); ++i) {
            x = t.charAt(i);
            pos = x - 'a';
            if (charMapS[pos] < 1) {
                return x;
            } else {
                charMapS[pos]--;
            }
        }

        return x;
    }
}
