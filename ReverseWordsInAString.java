package com.raghvendra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if(s == null) return s;
        s= s.trim();
        String [] wordsString = s.split(" ");
        System.out.println("WordsString: " + Arrays.toString(wordsString));
        List<String> words =  new ArrayList<>();
        for(String a: wordsString) {
            //Logic to check if the string contains 
            if(a.trim().length() != 0) {
                words.add(a);
            }
        }
        int wordsStringLength = words.size();
        String resultantString = "";
        for(int i = wordsStringLength-1; i >= 0; i --){
            resultantString += words.get(i)+" ";
            // below logic can be replaced by using .trim() in the string before returning the string.
            if(i != 0){
                resultantString += " ";
            }
        }
        return resultantString;
    }
}
