package com.raghvendra;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
    private static final String [] MORSE_ALPHABET = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for(String word : words) {
            set.add(getMorseCode(word));
        }

        return set.size();
    }

    private String getMorseCode(String word) {
        StringBuilder sb = new StringBuilder();
        for(char c : word.toCharArray()) {
            sb.append(MORSE_ALPHABET[c - 'a']);
        }
        return sb.toString();
    }
}
