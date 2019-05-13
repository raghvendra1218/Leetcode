package com.raghvendra;

/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

/**
 * Approach : if we go to basics and do the multiplication the way we do, we could see that:
 * num1[i] * num2[j] = numres[i+j, i+j+1]
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int num1Length = num1.length();
        int num2Length = num2.length();
        int [] result = new int[num1Length + num2Length];

        for(int i = num1Length - 1; i >=0; --i){
            for(int j = num2Length - 1; j >=0; --j){
                int mul = (num1.charAt(i) -'0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + result[p2];

                result[p1] += sum / 10;
                result[p2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : result){
            if(!(sb.length() == 0 && p == 0)) sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
