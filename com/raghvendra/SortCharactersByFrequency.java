package com.raghvendra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Approach -1 Using HashMap and Priority Queue
Time Complexity - O(nlogm), m: height of the queue
 */
public class SortCharactersByFrequency {
//    public String frequencySort(String s) {
//        //Stroe the String in HashTable with Character counts
//        Map<Character, Integer> myMap = new HashMap<>();
//        for(Character c : s.toCharArray()){
//            myMap.put(c, myMap.getOrDefault(c,0)+1);
//        }
//
//        //Arrange the entire map in the Priority Queue in Descending order
//        PriorityQueue<Character> myHeap =  new PriorityQueue<>((x,y) -> myMap.get(y) - myMap.get(x));
//        for(char c : myMap.keySet()){
//            myHeap.add(c);
//        }
//
//        //Traverse through map and output the values
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i<myMap.size();++i){
//            char temp  = myHeap.poll();
//            int temp1 = myMap.get(temp);
//            while(temp1 > 0){
//                sb.append(temp);
//                temp1--;
//            }
//        }
//        return new String(sb);
//    }
    /*
    Approach -2 Using HashMap and Bucket Sort Algo
     */

    public String frequencySort(String s) {
        //Store the String in HashTable with Character counts
        Map<Character, Integer> myMap = new HashMap<>();
        for(Character c : s.toCharArray()){
            myMap.put(c, myMap.getOrDefault(c,0)+1);
        }

        //Create a new bucket of type List of Chars of string length plus one
        //Insert the list of characters from map (as per their frequency) with frequency being the index of the bucket.
        List<Character>[] bucket = new List[s.length() + 1];
        for(char c : myMap.keySet()){
            int frequency = myMap.get(c);
            //Check if there is any char present on the index of bucket[frequency]
            if(bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
                bucket[frequency].add(c);
        }

        //Create a String for storing the result
        //since index marks the frequency of the chars came, hence we should iterate from the end of the bucket
        StringBuilder sb = new StringBuilder();
        for(int pos = bucket.length-1; pos>=0; --pos){
            //checking if the index contains any character value or not
            if(bucket[pos] != null){
                //traversing the entire character ArrayList with same frequency count
                for(char c: bucket[pos]){
                    //Appending the characters as amny times as their value corresponding in the map
                    for(int count = 0; count < myMap.get(c); count++){
                        sb.append(c);
                    }
                }
            }
        }
        return new String(sb);
    }
}
