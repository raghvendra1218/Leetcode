package com.raghvendra;

public class PalindromicSubstrings {
    private int count = 0;
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        for(int index = 0; index < s.length(); ++index){  //index denotes center along which we will extend
            checkPalindrome(s, index, index); //odd length
            checkPalindrome(s, index, index + 1); //Even length
        }
        return count;
    }

    private void checkPalindrome(String s, int left, int right){
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
    }
}