package com.raghvendra;

public class IntegerToRoman {
    //Initialise two arrays Numerals and values which could be used as a look up while performing operation on Integer number
    private static final String[] NUMERALS = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] VALUES = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public String intToRoman(int num) {
        if (num > 3999 || num < 1) return "";
        StringBuilder result = new StringBuilder();

        //We will iterate over Numerals and values array and in each run we will subtract the
        int i = 0;
        while (num > 0) {
            if (num - VALUES[i] >= 0) {
                result.append(NUMERALS[i]);
                num -= VALUES[i];
            } else {
                i++;
            }
        }
        return new String(result);
    }
}
