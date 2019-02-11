package com.raghvendra;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s.length()== 0 || s.length() == 1) return s;
        boolean flag = true;
        boolean flag2 = false;
        int startIndex = 0;
        int endIndex = 0;
        int prevLengthSubstring = -1;
        int start = 0, end = s.length()-1;
        while(start < end){
            if(s.charAt(start) == s.charAt(end)){
                if(isPalindrome(s.substring(start,end+1))){
                    int length =  (end+1)-start;
                    if(flag || length > prevLengthSubstring){
                        flag2 = true;
                        startIndex = start;
                        endIndex = end+1;
                        prevLengthSubstring = (end+1)-start;
                        flag = false;
                    }
                }
            }
            end--;
            if(start == end){
                end = s.length()-1;
                start++;
            }
        }
        if(flag2) return s.substring(startIndex,endIndex);
        return Character.toString(s.charAt(s.length()-1));
    }

    public boolean isPalindrome(String str){
        int i = 0, j= str.length()-1;
        while(i < j){
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
