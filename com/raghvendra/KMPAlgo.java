package com.raghvendra;

public class KMPAlgo {
    private int[] patternArray (String str){
        int i = 1;
        int j = 0;
        int [] pat = new int[str.length()];
        pat[0] = 0;
        while(i < str.length()){
            if(str.charAt(i) == str.charAt(j)){
                //value of ith index will be value of the index j plus one, both i and j will increment
                pat[i] = j+1;
                i++;
                j++;
            } else {
                // value of j will point to the value at the previous index of j
                if(j != 0){
                    j = pat[j-1];
                } else {
                    pat[i] = 0;
                    i++;
                }
            }
        }
//        System.out.println(Arrays.toString(pat));
        return pat;
    }

    public boolean KMP(String text, String pattern){
        int [] pat = patternArray(pattern);
        int i = 0;
        int j = 0;
        while(i < text.length() && j < pattern.length()){
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            } else {
                if(j!=0){
                    j = pat[j-1];
                } else {
                    i++;
                }
            }
        }
        /* If j is at the end of the index, it means that string pattern is a match */
        if(j == pattern.length()){
            return true;
        } else {
            return false;
        }
    }
}
