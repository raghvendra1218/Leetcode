package com.raghvendra;

public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int minDistance = Integer.MAX_VALUE;
        int word1Idx = -1;
        int word2Idx = -1;
        for(int i = 0; i < words.length; ++i) {
            if(words[i].equals(word1)) {
                word1Idx = i;
            } else if(words[i].equals(word2)) {
                word2Idx = i;
            }
            if (word1Idx >= 0 && word2Idx >= 0) {
                minDistance = Math.min(minDistance, Math.abs(word2Idx - word1Idx));
            }
        }

        return minDistance;
    }
}
