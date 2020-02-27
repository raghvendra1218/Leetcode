package com.raghvendra;

import java.util.Stack;

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        char[] chars =  S.toCharArray();
        int i =0, j = S.length()-1;
        while(i<j){
            if(!Character.isLetter(chars[i])){
                i++;
            }
            if(!Character.isLetter(chars[j])){
                j--;
            } else if(Character.isLetter(chars[i]) && Character.isLetter(chars[j])){ //we can remove this else if condition and place continue in both the if blocks check with input str "7_28]" you will come to know the problem
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c: chars){
            sb.append(c);
        }
        return new String(sb);
    }

/*
    Second Approach
 */
//    public String reverseOnlyLetters(String S) {
//        Stack<Character> letters = new Stack();
//        for (char c: S.toCharArray())
//            if (Character.isLetter(c))
//                letters.push(c);
//
//        StringBuilder ans = new StringBuilder();
//        for (char c: S.toCharArray()) {
//            if (Character.isLetter(c))
//                ans.append(letters.pop());
//            else
//                ans.append(c);
//        }
//
//        return ans.toString();
//    }
}
