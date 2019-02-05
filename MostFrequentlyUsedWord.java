package com.raghvendra;

/*
Asked in Amazon Interview
 */

import java.util.*;

public class MostFrequentlyUsedWord {
    List<String> retrieveMostFrequentlyUseWords (String literatureText, List<String> wordsToExeclude){
        String [] textString = literatureText.split(" ");
        Map<String, Integer> textMap = new HashMap<>();
        List<String> result = new ArrayList<>();

        for(int i = 0; i < textString.length; ++i){
            if(textMap.containsKey(textString[i])){
                textMap.put(textString[i],textMap.get(textString[i])+1);
            } else {
                textMap.put(textString[i],1);
            }
        }

        for(String s : wordsToExeclude){
            if(textMap.containsKey(s)){
                textMap.remove(s);
            }
        }

        int maxValueInMap = (Collections.max(textMap.values()));
        for(Map.Entry<String, Integer> entry : textMap.entrySet()){
            if(entry.getValue() == maxValueInMap){
                result.add(entry.getKey());
            }
        }
        for(String s: result){
            System.out.println(s);
        }
        return result;
    }
}
