package com.raghvendra;

public class GoatLatin {
    public String toGoatLatin(String S) {
        if(S == null || S.length() == 0) return "";
        String[] words =  S.split(" ");
        StringBuilder result  = new StringBuilder();
        int counter = 1;
        for (String word : words) {
            StringBuilder temp = new StringBuilder(word);
            if (!isVowel(word.toLowerCase().charAt(0))) {
                char tempChar = temp.charAt(0);
                temp.deleteCharAt(0);
                System.out.println(temp);
                temp.append(tempChar);
            }
            temp.append("ma");
            appendA(temp, counter);
            temp.append(" ");
            result.append(temp);
            counter++;
        }

        return new String(result).trim();
    }

    private boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }

        return false;
    }

    private void appendA(StringBuilder temp, int counter) {
        for(int i = counter; i > 0; --i) {
            temp.append('a');
        }
    }
}
