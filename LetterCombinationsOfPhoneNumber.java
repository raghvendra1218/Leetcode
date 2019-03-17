package com.raghvendra;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result;
        String [] mapping = new String[]{
            "0",
            "1",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };

        String current = "";
        permuteCombinations(result, current, digits, 0, mapping);
        return result;
    }

    private void permuteCombinations(List<String> result, String current, String digits, int index, String [] mapping){
        if(index == digits.length()){
            result.add(current);
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];
        for(int i = 0; i < letters.length() ; ++i){
            permuteCombinations(result, current + letters.charAt(i), digits, index + 1, mapping);
        }
    }
}
