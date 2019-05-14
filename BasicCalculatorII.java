package com.raghvendra;

/*
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
Note:

You may assume that the given expression is always valid.
Do not use the eval built-in library function.
 */

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        int num = 0;
        Stack<Integer> myStack = new Stack<>();
        char sign  = '+';
        s.trim();
        for(int i = 0; i < s.length(); ++i){
            if(Character.isDigit(s.charAt(i))){
                num = num * 10 + s.charAt(i) - '0';
            }
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1){
                if(sign == '+'){
                    myStack.push(num);
                } else if(sign == '-'){
                    myStack.push(-num);
                } else if(sign == '*'){
                    myStack.push(myStack.pop() * num);
                } else if(sign == '/'){
                    myStack.push(myStack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        for(int i : myStack){
            ans += i;
        }
        return ans;
    }
}
