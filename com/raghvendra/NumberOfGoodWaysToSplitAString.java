package com.raghvendra;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberOfGoodWaysToSplitAString {
    public int numSplits(String s) {
        if (s == null || s.length() == 0) return 0;

        Map<Character, Integer> myMap = new HashMap<>();
        Set<Character> mySet = new HashSet<>();
        int countNumSplits = 0;
        char [] sChar = s.toCharArray();

        for(char c : sChar) {
            myMap.put(c, myMap.getOrDefault(c, 0) + 1);
        }

        for(char c : sChar) {
            mySet.add(c);
            if(myMap.get(c) > 1) {
                myMap.put(c, myMap.get(c) - 1);
            } else {
                myMap.remove(c);
            }

            if (mySet.size() == myMap.size()) {
                countNumSplits++;
            }
        }

        return countNumSplits;
    }
}
