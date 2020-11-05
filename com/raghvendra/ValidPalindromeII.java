package com.raghvendra;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }

        return isP(s, 1);
    }

    private boolean isP(String s, int count) {
        int i = 0, j = s.length() - 1 ;

        while (i < j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);

            if (ci == cj) {
                i++;
                j--;
            } else if (count > 0) {
                //two possibility
                String sub1 = s.substring(i, j);
                String sub2 = s.substring(i + 1, j + 1);
                return isP(sub1, count - 1) || isP(sub2, count - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
