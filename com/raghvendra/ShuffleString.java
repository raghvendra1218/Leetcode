package com.raghvendra;

public class ShuffleString {
    public String restoreString(String s, int[] indices) {
        char[] list = new char[indices.length];
        for(int i = 0; i < indices.length; ++i) {
            list[indices[i]] =  s.charAt(i);
        }

        return new String(list);
    }
}
