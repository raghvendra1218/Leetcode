package com.raghvendra;
/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
 */

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> myStack = new Stack<>();
        //initialize the stack with -1
        myStack.push(-1);
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '('){
                myStack.push(i);
            } else {
                myStack.pop();
                if(myStack.isEmpty()){
                    myStack.push(i);
                } else {
                    max = Math.max(i - myStack.peek(), max);
                }
            }
        }
        return max;
    }
}
