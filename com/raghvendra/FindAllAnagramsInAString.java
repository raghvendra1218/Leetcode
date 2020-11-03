package com.raghvendra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        int ns = s.length();
        int np = p.length();
        if(ns < np) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // fill the pCount
        for(char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // traverse through s
        for(int i = 0; i < ns; ++i) {
            sCount[s.charAt(i) - 'a']++;
            // remove from sCount first's position if i >= np
            if(i >= np) {
                sCount[s.charAt(i - np) - 'a']--;
            }

            // compare two arrays if equal
            if(Arrays.equals(sCount, pCount)) {
                result.add(i - np + 1);
            }
        }

        return result;
    }
}
