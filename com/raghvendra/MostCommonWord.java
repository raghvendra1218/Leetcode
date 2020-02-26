package com.raghvendra;

import java.util.HashMap;
import java.util.Map;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
/*        String[] paragraphWords =  paragraph.toLowerCase().split("[ !?',;.]+");

        Map<String,Integer> wordMap = new HashMap<>();
        for(String s: paragraphWords){
            wordMap.put(s, wordMap.getOrDefault(s,0)+1);
        }

        for(String s : banned){
            if(wordMap.containsKey(s)){
                wordMap.remove(s);
            }
        }

        int maxValueInWordMap = Collections.max(wordMap.values());
        for( Map.Entry<String, Integer> entry: wordMap.entrySet()){
            if(entry.getValue() == maxValueInWordMap) return entry.getKey();
        }
        return paragraph;*/

        /** Approach 2: not using collections.max */

        String[] paragraphWords =  paragraph.toLowerCase().split("[ !?',;.]+");
        Map<String,Integer> wordMap = new HashMap<>();
        //Storing the words and the count value in Hashmap
        for(String word: paragraphWords) wordMap.put(word, wordMap.getOrDefault(word,0)+1);
        //Removing the keys for the banned words
        for(String bannedWord : banned) if(wordMap.containsKey(bannedWord)) wordMap.remove(bannedWord);
        //Beautiful approach used below to find out the key associated with maximum value in a Map
        String res = null;
        for(String word : wordMap.keySet())
            if(res == null || wordMap.get(word) > wordMap.get(res))
                res = word;
        return res;
    }
}
