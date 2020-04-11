package com.raghvendra;

import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors.
 * # means a backspace character.
 *
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * Follow up:
 *
 * Can you solve it in O(N) time and O(1) space?
 */
public class BackspaceStringCompare {

    /**
     * Approach 1: Using Stack and pop when '#' found
     */

    public boolean backspaceCompare(String S, String T) {
        String SSB = formActualString(S);
        String TSB = formActualString(T);
        return SSB.equals(TSB);
    }

    private String formActualString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(!stack.isEmpty() && c == '#') {
                stack.pop();
            } else if(c != '#') {
                stack.push(c);
            }
        }

        //Check if stack is empty we can return an empty string
        if (stack.size() == 0)  return "";

        //Form the string from the stack
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}
