package com.raghvendra;

public class StringCompression {
    public void compress(String str){
//        System.out.println("Input String: "+str);
        if (str.length() == 0)return;
        int backTrackPointer = 0, characterCount = 1;
        int forwardPointer = 1;
        StringBuilder sb = new StringBuilder();
        while(forwardPointer < str.length()){
            if(str.charAt(backTrackPointer) == str.charAt(forwardPointer)){
                ++characterCount;
                ++forwardPointer;
            } else {
                sb.append(str.charAt(backTrackPointer));
                sb.append(characterCount);
                characterCount = 1;
                ++forwardPointer;
                backTrackPointer = forwardPointer - 1;
            }
        }
        sb.append(str.charAt(backTrackPointer));
        sb.append(characterCount);
        System.out.println("Output String: "+ new String(sb));
    }
}
