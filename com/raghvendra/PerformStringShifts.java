package com.raghvendra;

/**
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 *
 * direction can be 0 (for left shift) or 1 (for right shift).
 * amount is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc", shift = [[0,1],[1,2]]
 * Output: "cab"
 * Explanation:
 * [0,1] means shift to left by 1. "abc" -> "bca"
 * [1,2] means shift to right by 2. "bca" -> "cab"
 * Example 2:
 *
 * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
 * Output: "efgabcd"
 * Explanation:
 * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
 * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
 * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
 * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 *
 * Constraints:
 *
 * 1 <= s.length <= 100
 * s only contains lower case English letters.
 * 1 <= shift.length <= 100
 * shift[i].length == 2
 * 0 <= shift[i][0] <= 1
 * 0 <= shift[i][1] <= 100
 */

public class PerformStringShifts {
    /**
     * Approach 1: As per the move perform the left and right shifts.
     *             Seems like bad memory consumption here
     */
    public String stringShift(String s, int[][] shift) {
        StringBuilder sb = new StringBuilder(s);
        System.out.println(sb.toString());
        for(int[] oneShift : shift) {
            //Left Shift
            if(oneShift[0] == 1) {
                rightShift(sb, oneShift[1]);
            } else {
                leftShift(sb, oneShift[1]);
            }
        }

        return sb.toString();
    }

    private void leftShift(StringBuilder sb, int i) {
        int len = sb.length();
        int moves = i % len;
        while(moves != 0) {
            char c = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(c);
            moves++;
        }
    }

    private void rightShift( StringBuilder sb, int i) {
        int len = sb.length();
        int moves = i % len;
        while(moves != 0) {
            char c = sb.charAt(len - 1);
            sb.deleteCharAt(len - 1);
            sb.insert(0, c);
            moves++;
        }
    }
}
