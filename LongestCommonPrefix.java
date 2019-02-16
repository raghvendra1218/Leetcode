package com.raghvendra;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs){
        if(strs.length == 0) return "";
        StringBuilder result = new StringBuilder();
        result.append(strs[0]);
        for(int i = 1; i < strs.length; ++i){
            int j = 0;
            while(j < result.length() &&  j < strs[i].length()) {
                if (result.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
                j++;
            }
            result = new StringBuilder(result.substring(0, j));
        }
        return new String(result);
    }
}
