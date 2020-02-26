package com.raghvendra;

public class GreatestCommonDivisorOfStrings {

    /**
     * Approach 1: Simple Iterative solution, first attempt
     * @param str1
     * @param str2
     * @return
     */
/*    public String gcdOfStrings(String str1, String str2) {
        if(str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) return "";
        //Check the smaller length string
        int lengthstr1 = str1.length();
        int lengthstr2 = str2.length();
        int smallerLength = (lengthstr1 <= lengthstr2) ? lengthstr1 : lengthstr2;
        String smallerStr = (smallerLength == lengthstr1) ? str1 : str2;
        String largerStr = (smallerLength < lengthstr1) ? str1 : str2;
        // System.out.println(smallerStr);
        for(int i = smallerLength - 1; i >=0; --i){
            String s = smallerStr.substring(0, i+1);
            // System.out.println("s:" + s);
            int largelooplen = largerStr.length() / s.length();
            int smalllooplen = smallerStr.length() / s.length();
            StringBuilder sb = new StringBuilder();
            for(int j = 1; j <= smalllooplen; j++){
                sb.append(s);
            }
            if(!smallerStr.equals(sb.toString())) continue;
            sb = new StringBuilder();
            for(int j = 1; j <= largelooplen; j++){
                sb.append(s);
            }
            if(largerStr.equals(sb.toString())) return s;
            // System.out.println("sb: "+ sb);

        }
        return "";
    }*/

    /**
     * Approach 2: Recursive Solution, more efficient
     * Step 1: Identify the shorter among the two, and check if the longer exactly contains the entire shorter, if not return "",
     * else continue to shorten it with the length of the shorter string till one of them becomes empty.
     *
     * If longer string starts with shorter string, cut off the common prefix part of the longer string;
     * repeat till one is empty, then the other is gcd string;
     * If the longer string does NOT start with the shorter one, there is no gcd string
     * @param str1
     * @param str2
     * @return
     */

    public String gcdOfStrings(String str1, String str2) {
        if(str1.length() < str2.length()){
            return gcdOfStrings(str2, str1);  //make sure str1 is always larger than str2
        }
        else if(!str1.startsWith(str2)){    // if the longer string does not contain entire str2 , then return empty string
            return "";
        }else if(str2.isEmpty()){  // once the smaller string becomes empty, it means we have found the smallest chunk which comprises both the strings str1 and str2, that is our desired result
            return str1;  //gcd of string found
        }else {
            return gcdOfStrings(str1.substring(str2.length()), str2); //cut the common prefix from the long string
        }
    }
}
