package com.raghvendra;

/**
 * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * Follow up: Could you do it in-place without allocating extra space?
 */

public class ReverseWordsInAStringII {
    public void reverseWords(char[] str) {
        int startIndex = 0, endIndex = str.length-1;
        str = reverse(str,startIndex,endIndex);
        for(int i = 0; i < str.length; ++i){
            if(str[i] == ' '){
                endIndex = i-1;
                str = reverse(str, startIndex, endIndex);
                startIndex = i+1;
            }
        }
        str = reverse(str, startIndex, str.length-1);
    }

    private char[] reverse(char[] str, int startIndex, int endIndex){
        while(startIndex < endIndex){
            char temp = str[startIndex];
            str[startIndex] = str[endIndex];
            str[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
        return str;
    }
}
