package com.raghvendra;

public class StringToInteger {
    public int myAtoi(String str) {
        int ans = 0;
        int index = 0;
        int sign = 1;

        //Empty String
        if(str.length() == 0) return 0;

        //Remove Spaces
        while(index < str.length() && str.charAt(index) == ' '){
            index ++;
        }

        //Handle signs
        if(index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')){
//            sign = str.charAt(index) == '+' ? 1 : -1;
            if(str.charAt(index) == '+'){
                sign = 1;
            } else {
                sign = -1;
            }
            index++;
        }

        //Convert number
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9){
                break;
            }
//            if(Integer.MAX_VALUE/10 < ans || Integer.MAX_VALUE/10 == ans && Integer.MAX_VALUE%10 < digit){
//                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//            }
            if((Integer.MAX_VALUE - digit) / 10 < ans) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            ans = 10 * ans + digit;
            index++;
        }
        return ans * sign;
    }
}