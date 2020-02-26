package com.raghvendra;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
    public List<String> permutations(String s){
        ArrayList<String>result = new ArrayList<>();
        permute("", s, result);
        return result;
    }

    private void permute(String prefix, String suffix, ArrayList<String>result){
        if(suffix.length() == 0){
            result.add(prefix);
        } else {
            for(int i = 0; i < suffix.length(); ++i){
                permute(prefix + suffix.charAt(i), suffix.substring(0,i) + suffix.substring(i+1,suffix.length()), result);
            }
        }
    }
}