package com.raghvendra;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordMap = new TreeMap<>();

        //Traverse through the Array of words and store in map
        for(String s : words){
            wordMap.put(s, wordMap.getOrDefault(s, 0) +1);
        }

        //Create a bucket of String which can contain words of same frequency at it's index which is bucket[frequency]
        List<String>[] bucket = new List[words.length + 1];
        for(String s : wordMap.keySet()){
            int frequency = wordMap.get(s);
            if(bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(s);
        }

        //Traverse through the bucket from end, because we need the highest frequent things stored in the bucket
        //Make an arrayList to store the result
        List<String> result = new ArrayList<>();
        for(int pos = bucket.length-1; pos >=0; --pos){
            if(bucket[pos] != null){
                for(String s: bucket[pos]){
                    if(k > 0){
                        result.add(s);
                        k--;
                    }
                }
            }
        }
        return result;
    }
}
