package com.raghvendra;

import java.util.Arrays;

public class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        int[] characters = new int[255];
        Arrays.fill(characters, 0);
        for(int i = 0; i < s.length(); i++){
            characters[(int)s.charAt(i)]++;
        }
        for(int i =0; i < s.length(); i++){
            if(characters[s.charAt(i)] ==1){
                return i;
            }
        }
        return -1;
    }
}
