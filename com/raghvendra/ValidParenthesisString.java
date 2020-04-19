package com.raghvendra;

import java.util.Stack;

/**
 * Given a string containing only three types of characters: '(', ')' and '*',
 * write a function to check whether this string is valid. We define the validity of a string by these rules:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * Example 1:
 * Input: "()"
 * Output: True
 * Example 2:
 * Input: "(*)"
 * Output: True
 * Example 3:
 * Input: "(*))"
 * Output: True
 * Note:
 * The string size will be in the range [1, 100].
 */
public class ValidParenthesisString {
    /**
     * Approach 1: Two stacks one for keeping the index of the Stars and the other for keeping the index of open brackets
     * @param s, String
     * @return true/false, depending on s makes valid parenthesis string as per above conditions.
     */
    public boolean checkValidString(String s) {
        Stack<Integer> star = new Stack<>();
        Stack<Integer> openBracket = new Stack<>();

        //traverse the string
        for(int i = 0;  i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                openBracket.push(i);
            } else if (c == '*') {
                star.push(i);
            } else {
                if(!openBracket.isEmpty()) {
                    openBracket.pop();
                } else if(!star.isEmpty()){
                    star.pop();
                } else {
                    return false;
                }
            }
        }

        //Balance the open brackets, if openBracket is filled
        while(!openBracket.isEmpty()) {
            //This condition is that the '*' index should be greater than index of open bracket , then only star will
            //be able to fill in as closing bracket, there is no use if there are stars and if they lie before the index
            //of the opening bracket.
            if(!star.isEmpty() && star.peek() > openBracket.peek()) {
                star.pop();
                openBracket.pop();
            } else {
                return false;
            }
        }
        return true;
    }
}
