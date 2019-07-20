package com.raghvendra;

public class GreatestCommonDivisorOfStrings {

    /**
     * Approach 1: Simple Iterative solution, first attempt
     * @param str1
     * @param str2
     * @return
     */
//    public String gcdOfStrings(String str1, String str2) {
//        if(str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) return "";
//        //Check the smaller length string
//        int lengthstr1 = str1.length();
//        int lengthstr2 = str2.length();
//        int smallerLength = (lengthstr1 <= lengthstr2) ? lengthstr1 : lengthstr2;
//        String smallerStr = (smallerLength == lengthstr1) ? str1 : str2;
//        String largerStr = (smallerLength < lengthstr1) ? str1 : str2;
//        // System.out.println(smallerStr);
//        for(int i = smallerLength - 1; i >=0; --i){
//            String s = smallerStr.substring(0, i+1);
//            // System.out.println("s:" + s);
//            int largelooplen = largerStr.length() / s.length();
//            int smalllooplen = smallerStr.length() / s.length();
//            StringBuilder sb = new StringBuilder();
//            for(int j = 1; j <= smalllooplen; j++){
//                sb.append(s);
//            }
//            if(!smallerStr.equals(sb.toString())) continue;
//            sb = new StringBuilder();
//            for(int j = 1; j <= largelooplen; j++){
//                sb.append(s);
//            }
//            if(largerStr.equals(sb.toString())) return s;
//            // System.out.println("sb: "+ sb);
//
//        }
//        return "";
//    }

    /**
     * Approach 2: Recursive Solution, more efficient
     * @param str1
     * @param str2
     * @return
     */

    public String gcdOfStrings(String str1, String str2) {

    }
}
