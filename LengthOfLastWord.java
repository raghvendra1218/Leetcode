/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word
 * (last word means the last appearing word if we loop from left to right) in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a maximal substring consisting of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 */

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        //Split the string by space and store in an array of string of words
        String[] words = s.split(" ");
        //Check for the array size, to avoid index out of bounnd exceptions
        if(words.length == 0) return 0;
        String lastWord = words[words.length - 1];
        //Check for the last word if null or length 0, then return 0
        return (lastWord == null || lastWord.length() == 0) ? 0 : lastWord.length();
    }
}
