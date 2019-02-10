package com.raghvendra;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        int[] letters = new int[255];
        for(int i = 0; i < S.length(); i++){
            letters[(int)S.charAt(i)]++;
        }
        for(int j = 0; j <J.length();j++){
            count+=letters[J.charAt(j)];
        }
        return count;
    }
}
