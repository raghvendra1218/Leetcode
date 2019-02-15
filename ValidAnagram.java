package com.raghvendra;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int [] mapS = new int[128];
        int [] mapT = new int[128];
        for(char cs : s.toCharArray()){
            mapS[cs]++;
        }
        for(char ct : t.toCharArray()){
            mapT[ct]++;
        }
        for(int i = 0; i<mapS.length;++i){
            if(mapS[i] != mapT[i]){
                return false;
            }
        }
        return true;
    }
}
