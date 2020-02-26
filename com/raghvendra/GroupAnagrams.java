package com.raghvendra;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        /** Brute Force */
/*        List<List<String>> result = new ArrayList<>();
        List<String> anagrams = new ArrayList<>();
        boolean[] map =  new boolean[strs.length];
        for(int j =0; j <map.length; ++j){
            if(!map[j]){
                for(int i = j; i < strs.length; ++i){
                    if(anagrams.isEmpty() || isAnagram(anagrams.get(0), strs[i])){
                        anagrams.add(strs[i]);
                        map[i] = true;
                    }
                }
                result.add(anagrams);
                anagrams = new ArrayList<>();
            }
        }
        return result;
    }

    private boolean isAnagram(String source, String target){
        char[] sourceMap = new char[255];
        char[] targetMap = new char[255];
        for(char sm: source.toCharArray()){
            sourceMap[sm]++;
        }

        for(char tm : target.toCharArray()){
            targetMap[tm]++;
        }

        for(int i = 0; i<sourceMap.length;++i){
            if(sourceMap[i] != targetMap[i]){
                return false;
            }
        }
        return true;*/

    /** Approach 2 :  Using HashMap */ //very efficient solution`
        if(strs == null) return new ArrayList<>();
        Map<String, List<String>> myMap = new HashMap<>();
        for(String word : strs){
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if(!myMap.containsKey(key)) myMap.put(key,new ArrayList<>());
            myMap.get(key).add(word);
        }
        return new ArrayList<>(myMap.values());
    }

}
