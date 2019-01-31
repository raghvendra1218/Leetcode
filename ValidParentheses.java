package com.raghvendra;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
//        Stack<Character> myStack = new Stack<>();
//        for (char c : s.toCharArray()) {
//            if (c == '(')
//                myStack.push(')');
//            else if (c == '{')
//                myStack.push('}');
//            else if (c == '[')
//                myStack.push(']');
//            else if (myStack.isEmpty() || myStack.pop() != c)
//                return false;
//        }
//        return myStack.empty();

        //Second approach
        Map<Character,Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            } else {
                try {
                    if(stack.pop() != map.get(s.charAt(i))) return false;
                }
                catch (EmptyStackException e){
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
