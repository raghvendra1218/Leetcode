package com.raghvendra;

public class    PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0 ||  (x % 10 == 0 && x!=0)) return false;
        int ans = 0;
        int rem = 0;
        while(x > ans){
            rem = x % 10;
            ans = ans * 10 + rem;
            x = x / 10;
        }
        if(x == ans || ans/10 == x) return true;
        return false;
    }
}
