package com.raghvendra;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
 * You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 *
 * Example 1:
 *
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 *
 * Input: "aba"
 * Output: False
 * Example 3:
 *
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */

public class RepeatedSubstringPattern {
    /**
     *Approach 1: We want to start from mid of string and find substrings which on concatenating with itself can give us
     *            complete string passed in function argument 's'.
     *            Why mid of string because we can if it is substring from mid then it had to
     *            exactly same as after index len/2 in order to qualify repeated.
     */
    public boolean repeatedSubstringPattern(String s) {
        //Calculate the length of the string 's'
        int len = s.length();

        for(int i = len/2 ; i > 0; --i) {

            //Check if the index on which we are, can completely form the original string s by repeating
            if(len % i == 0) {

                //Get the number of repeats to get the entire string s, that will used as part of loo ending condition
                //to form the entire string
                int num_repeats = len / i ;

                //get the substring
                String substr = s.substring(0, i);

                //Loop until num_repeats to form the string out of this substring
                StringBuilder sb = new StringBuilder(); //to store the result of the concatenated substring

//                sb.append(substr.repeat(num_repeats)); //Somehow this improves time complexity, rather than using the for loop below

                /* OR */
                for(int j = 1; j <= num_repeats; ++j) { //notice j = 1, because it's counter of repeats it cannot start from 0
                    sb.append(substr);
                }

                //Check the final string formed matches with the string 's'
                if(sb.toString().equals(s)) return true;
            }
        }
        return false;
    }
}
