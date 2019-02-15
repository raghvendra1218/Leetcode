package com.raghvendra;

public class RotateString {
    /*
        Approach 1 : Brute Force
     */

    public boolean rotateString(String A, String B) {
        if (A.length() != B.length())
            return false;
        if (A.length() == 0)
            return true;

        search:
        for (int s = 0; s < A.length(); ++s) {
            for (int i = 0; i < A.length(); ++i) {
                if (A.charAt((s+i) % A.length()) != B.charAt(i))
                    continue search;
            }
            return true;
        }
        return false;
    }

    /*
        Approach 2: KMP Algorithm
     */

//    public boolean rotateString(String A, String B) {
//        if(A.length() == B.length() && (A+A).contains(B)) return true;
//        return false;
//    }


    /*
        Approach 3: KMP Algorithm
     */

//    public boolean rotateString(String A, String B) {
//        if (A.length() != B.length())
//            return false;
//        if (A.length() == 0)
//            return true;
//
//        search:
//        for (int s = 0; s < A.length(); ++s) {
//            for (int i = 0; i < A.length(); ++i) {
//                if (A.charAt((s+i) % A.length()) != B.charAt(i))
//                    continue search;
//            }
//            return true;
//        }
//        return false;
//    }

}
