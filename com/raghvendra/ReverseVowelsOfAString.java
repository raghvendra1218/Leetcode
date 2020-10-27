package com.raghvendra;

public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return "";

        int start = 0;
        int end = s.length() - 1;
        char[] stringChar = s.toCharArray();

        while (start <= end) {
            char charStart = stringChar[start];
            char charEnd = stringChar[end];
            boolean isStartAVowel = isVowel(charStart);
            boolean isEndAVowel = isVowel(charEnd);

            if (!isStartAVowel) {
                start++;
            }

            if (!isEndAVowel) {
                end--;
            }

            if (isStartAVowel && isEndAVowel) {
                stringChar[end] = charStart;
                stringChar[start] = charEnd;
                start++;
                end--;
            }

        }

        return new String(stringChar);
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
