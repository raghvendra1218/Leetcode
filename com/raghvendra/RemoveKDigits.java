package com.raghvendra;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int len = num.length();

        //Handle corner case if k == length of num
        if(k == len) {
            return "0";
        }

        //Store the most significant digits in the stack, we are using the stack, because we need to maintain the order in which
        //digits are coming while traversing the number string
        Stack<Character> digits = new Stack<>();

        int i = 0;

        //pop the digit from the stack if the next digit in num is less than the top of stack
        while (i < len){
            while(!digits.isEmpty() && k > 0 && (digits.peek() > num.charAt(i))){
                digits.pop();
                k--;
            }
            digits.push(num.charAt(i));
            i++;
        }

        //Handle the case if the nums have same characters/digits and we have to remove the k digits
        //example: nums = 1111111, k = 3;
        while(k > 0){
            digits.pop();
            k--;
        }

        //Create a StringBuilder to store the number
        StringBuilder result = new StringBuilder();
        while(!digits.isEmpty()){
            result.append(digits.pop());
        }
        result = result.reverse();

        //Handle the leading zeros in the formed result
        while(result.length() > 1 && result.charAt(0) == '0'){
            result.deleteCharAt(0);
        }
        return new String(result);
    }
}
