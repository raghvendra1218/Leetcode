package com.raghvendra;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindingTheUsersActiveMinutes {
    public int[] findingUsersActiveMinutesII(int[][] logs, int k) {
        int[] result = new int[k];
        if (logs.length == 0) return result;
        int currentLogID = -1;
        int currentLogTime = -1;
        Map<Integer, Set<Integer>> myMap = new HashMap<>();

        for (int[] currentLog : logs) {
            currentLogID = currentLog[0];
            currentLogTime = currentLog[1];
            if (!myMap.containsKey(currentLogID)) {
                myMap.put(currentLogID, new HashSet<>());
            }
            myMap.get(currentLogID).add(currentLogTime);
        }

        System.out.println(myMap);
        for (Map.Entry<Integer, Set<Integer>> entry : myMap.entrySet()) {
            int UAM = entry.getValue().size();
            result[UAM - 1]++;
        }

        return result;
    }

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans = new int[k];

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] log : logs) {
            Set<Integer> set = map.computeIfAbsent(log[0], k1 -> new HashSet<>());

            set.add(log[1]);
        }

        for(Map.Entry<Integer, Set<Integer>> entry: map.entrySet()){
            int index = entry.getValue().size();
            ans[index-1]++;
        }

        return ans;
    }
}
