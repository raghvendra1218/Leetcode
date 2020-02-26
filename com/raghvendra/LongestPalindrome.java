package com.raghvendra;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int count = 0;
        boolean metOdd = true;
        int[] chars = new int[255];
        for(int i = 0; i < s.length(); ++i){
            chars[(int)s.charAt(i)]++;
        }
        for(int i : chars){
            if(i%2==0){
                count+=i;
            } else {
                if(metOdd){
                    count+=i;
                    metOdd = false;
                } else {
                    count += i-1;
                }
            }
        }
        return count;
    }
}
