package com.raghvendra;

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
