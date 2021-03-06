package com.raghvendra;
/*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.
 */

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> myStack = new Stack<>();
        int ans = 0;
        int sign = 1;
        int num = 0;
        for(int i = 0 ; i < s.length(); ++i){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            } else if(c == '+'){
                ans += sign * num;
                num = 0;
                sign = 1;
            } else if(c == '-'){
                ans += sign * num;
                sign = -1;
                num = 0;
            } else if(c == '('){
                myStack.push(ans);
                myStack.push(sign);
                //reset the sign
                sign = 1;
                ans = 0;
            } else if(c == ')'){
                ans += sign * num;
                num = 0;
                ans *= myStack.pop();  //stack.pop() is the sign before the parenthesis
                ans += myStack.pop();
            }
        }
        if(num != 0) ans += sign * num;
        return ans;
    }
}
