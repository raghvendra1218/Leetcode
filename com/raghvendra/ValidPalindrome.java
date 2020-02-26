package com.raghvendra;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
                continue;
            }
            if(s.toLowerCase().charAt(i) != s.toLowerCase().charAt(j)) return false;
            i++;
            j--;
        }
        return true;
        //Second method using regex
//        s = s.toLowerCase();
//        s= s.replaceAll("[^A-Z^a-z^0-9]+","");
//        for(int i =0, j = s.length()-1 ; i<j;i++,j--){
//            if(s.charAt(i)!=s.charAt(j)){
//                return false;
//            }
//        }
//        return true;
    }
}
