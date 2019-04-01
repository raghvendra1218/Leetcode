package com.raghvendra;

/*public class LongestPalindromicSubstring {
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
}*/

/**
 * Approach 2 : Time Complexity - O(n^2)
 */

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s.length() == 0) return "";
        int left = 0, right = 0, maxLength = 0;
        for(int index = 0; index < s.length(); ++index){
            int len1 = checkPalindrome(s, index, index);
            int len2 = checkPalindrome(s, index, index + 1);
            int len = Math.max(len1, len2);
            if(maxLength < len){
                left = index - (len-1)/2;
                right = index + (len/2);
                maxLength = len;
            }
        }
        return s.substring(left, right + 1);
    }

    public int checkPalindrome (String s, int left, int right){

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}
