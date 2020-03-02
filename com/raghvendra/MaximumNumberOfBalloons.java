package com.raghvendra;

/**
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
 * <p>
 * You can use each character in text at most once. Return the maximum number of instances that can be formed.
 * <p>
 * Example 1:
 * <p>
 * Input: text = "nlaebolko"
 * Output: 1
 * Example 2:
 * <p>
 * Input: text = "loonbalxballpoon"
 * Output: 2
 * Example 3:
 * <p>
 * Input: text = "leetcode"
 * Output: 0
 * <p>
 * Constraints:
 * <p>
 * 1 <= text.length <= 10^4
 * text consists of lower case English letters only.
 */

public class MaximumNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int b = 0, a = 0, l = 0, o = 0, n = 0;
        for (char c : text.toCharArray()) {
            switch (c) {
                case 'b':
                    ++b;
                    break;
                case 'a':
                    ++a;
                    break;
                case 'l':
                    ++l;
                    break;
                case 'o':
                    ++o;
                    break;
                case 'n':
                    ++n;
                    break;
            }
        }
        return Math.min(Math.min(l/2, o/2), Math.min(Math.min(b, a), n));
    }
}
