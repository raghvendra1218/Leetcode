package com.raghvendra;

public class ReverseWordsInAStringII {
    public void reverseWords(char[] str) {
        int stringLength = str.length;
        int initialIndex = 0;
        int finalIndex = 0;
        int counter = 0;
        while(counter < stringLength){
            if(str[counter] == ' '){
                finalIndex = counter;
//                migrateChunk(initialIndex, finalIndex, str);
                initialIndex = finalIndex;
            }
        }
    }

    public void reverseString(int initialIndex, int finalIndex, char[]str){
        int slidingwindow = 0;
        slidingwindow += finalIndex - initialIndex;
        for(int i = str.length-slidingwindow; i>0; i-- ){

        }
    }
}
