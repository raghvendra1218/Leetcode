package com.raghvendra;

/**
 * Given an input string, reverse the string word by word.
 *
 *
 *
 * Example 1:
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Follow up:
 *
 * For C programmers, try to solve it in-place in O(1) extra space.
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
//        if(s == null) return s;
//        s= s.trim();
//        String [] wordsString = s.split(" ");
//        System.out.println("WordsString: " + Arrays.toString(wordsString));
//        List<String> words =  new ArrayList<>();
//        for(String a: wordsString) {
//            //Logic to check if the string contains white space, if present do not add in the List
//            if(a.trim().length() != 0) {
//                words.add(a);
//            }
//        }
//        int wordsStringLength = words.size();
//        String resultantString = "";
//        for(int i = wordsStringLength-1; i >= 0; i --){
//            resultantString += words.get(i)+" ";
//            // below logic can be replaced by using .trim() in the string before returning the string.
//            if(i != 0){
//                resultantString += " ";
//            }
//        }
//        return resultantString;

    //leetcode solution
    if(s == null) return null;
    StringBuilder sb = new StringBuilder();
    int i = s.length()-1;
        while (i>=0){
            if(s.charAt(i) == ' '){
                i--;
                continue;
            }
        int index = s.lastIndexOf(' ',i);
        sb.append(s.substring(index+1,i+1));
        sb.append(' ');
        i = index;
    }
        return sb.toString().trim();
    }
}
