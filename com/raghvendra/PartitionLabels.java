package com.raghvendra;

import java.util.*;

public class PartitionLabels {

    // Approach1 : Keep the last index of the letter and Greedy algo
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();

        // traverse and keep the last index of the letter in the String
        int[] charMap = new int[26];
        for(int i = 0; i < S.length(); ++i) {
            charMap[S.charAt(i) - 'a'] = i;
        }

        // traverse through the String
        // Keep two pointers anchor and the j , j will keep the maxm index among the current letters in the string
        // anchor is more of a left pointer to keep the start of the substring of the partition
        int j = 0, anchor = 0;
        for(int i = 0; i < S.length(); ++i) {
            j = Math.max(j, charMap[S.charAt(i) - 'a']);
            if(i == j) {
                // partition found
                result.add(i - anchor + 1);  // adding 1 as index of array starts from 0
                anchor = i + 1;
            }
        }
        return result;
    }

    public List<Integer> partitionLabelsII(String S) {
        int len = S.length();
        List<Integer> result = new ArrayList<>();
        // traverse the the String and keep the count of all letters
        int[] charMap = new int[26];
        for(int i = 0; i < len; ++i) {
            charMap[S.charAt(i) - 'a']++;
        }

        // traverse through array and update the letter's count in charMap array
        // at any given point, if the count of all the distinct letters in the current substring becomes zero, that is the point of partition

        Set<Character> set = new HashSet<>(); // to track the number of distinct letters in the current string so far
        int leftPointer = 0; // to keep the pointer in order to keep the reference for start of partition
        int rightPointer = 0; // to keep the pointer in order to keep the reference for end of partition
        char c;  // current char
        for(int i = 0; i < len; ++i) {
            c = S.charAt(i);
            set.add(c);
            charMap[c - 'a']--;

            // check if the letter's count value is greater than zero
            Iterator<Character> it = set.iterator();
            int setLengthIndex = 0;
            char setChar;
            while(it.hasNext()) {
                setChar = it.next();
                if(charMap[setChar - 'a'] > 0) {
                    break;
                } else if(setLengthIndex == set.size() - 1) {
                    // found the partition
                    result.add(rightPointer - leftPointer + 1);
                    // Reset the Set and  leftPointer to rightPointer + 1
                    set = new HashSet<>();
                    leftPointer = rightPointer + 1;
                }
                setLengthIndex++;
            }

            rightPointer++;
        }

        return result;
    }
}
