package com.raghvendra;

import java.util.HashSet;
import java.util.Set;

public class FindTheTownJudge {

    // Solution Approach : 3ms
    public int findJudge(int N, int[][] trust) {
        if (trust.length < N - 1) return -1;

        // As we will keep the count of inward and outward direction for each people in this array, and a people cannot be 0
        int[] trustScores = new int[N + 1];
        for (int[] relation : trust) {
            // Adding the outward and subtracting the inwards connections
            trustScores[relation[0]]--;
            trustScores[relation[1]]++;
        }

        // In order to satisfy the 2nd property the index with N-1 value is our Judge , and of course it indicates it is positive
        for (int i = 1; i < trustScores.length; ++i) {
            if (trustScores[i] == N - 1) return i;
        }
        return -1;
    }


    // My way - 8ms
    public int findJudgeII(int N, int[][] trust) {
        if (trust.length < N - 1) {
            return -1;
        }
        if (N == 1 && trust.length == 0) return 1;
        Set<Integer> set = new HashSet<>();
        for (int[] ints : trust) {
            // Add the peoples in the set which can be judge, meaning the persons which are at index 1 of the trust
            set.add(ints[1]);
            set.remove(ints[0]);
        }

        // Remove the persons from the set which have  occurred at index 0 of trust
        for (int[] ints : trust) {
            set.remove(ints[0]);
        }

        // Check if the remaining contender have trust of all other peoples
        int countOfTrustFromDifferentPeople = 0, element = 0;
        if (!set.isEmpty()) {
            element = set.iterator().next();
            for (int[] ints : trust) {
                if (ints[1] == element) countOfTrustFromDifferentPeople++;
            }
        }

        return (countOfTrustFromDifferentPeople != N - 1) ? -1 : element;
    }
}
