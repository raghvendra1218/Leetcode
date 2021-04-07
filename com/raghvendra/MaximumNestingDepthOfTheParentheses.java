package com.raghvendra;

import java.util.Stack;

public class MaximumNestingDepthOfTheParentheses {
    public int maxDepth(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Character> myStack = new Stack<>();

        int depth = 0;
        for(char c: s.toCharArray()) {
            if (c == '(') {
                myStack.push(c);
                depth = Math.max(depth, myStack.size());
            } else if (c == ')') {
                myStack.pop();
            }
        }

        return depth;
    }
}
