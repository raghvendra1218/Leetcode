package com.raghvendra;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        int num = Integer.parseInt(s);
        if (num > 3999 || num < 1) return -1;
        StringBuilder result = new StringBuilder();
        Map<String, Integer> roman = new HashMap<>();
        roman.put("I", 1);
        roman.put("V", 5);
        roman.put("X", 10);
        roman.put("L", 50);
        roman.put("C", 100);
        roman.put("D", 500);
        roman.put("M", 1000);
        roman.put("CM", 900);
        roman.put("CD", 400);
        roman.put("XC", 90);
        roman.put("XL", 40);
        roman.put("IX", 9);
        roman.put("IV", 4);


        int len = s.length();
        int i = 0;
        while (num > 0) {


        }
        return -1;
    }
}
