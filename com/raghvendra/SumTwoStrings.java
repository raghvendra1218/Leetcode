package com.raghvendra;

import java.util.Arrays;

public class SumTwoStrings {
    public String sum(String s1, String s2){
        boolean carry  = false;
        int [] arrayS1 = new int[s1.length()];
        int [] arrayS2 =  new int[s2.length()];
        int [] result = new int[s1.length()];
        for(int i = 0; i <s1.length(); i++){
            arrayS1[i] = s1.charAt(i) - '0';
        }
        for(int i = 0; i <s2.length(); i++){
            arrayS2[i] = s2.charAt(i) - '0';
        }
//        System.out.println("Array 1: "+ Arrays.toString(arrayS1));
//        System.out.println("Array 2: "+ Arrays.toString(arrayS2));
        for(int i = s1.length()-1, j = s2.length()-1; i>=0; i--, j-- ){
            if(carry && i!=0){
                int temp = arrayS1[i] +arrayS2[j] + 1;
                if(temp >= 10){
                    result[i] = temp % 10;
                    carry = true;
                } else {
                    result[i] = temp;
                    carry = false;
                }
            } else if(i == 0) {
                int [] result1 = new int[s1.length() + 1];
                if(carry){
                    int temp = arrayS1[i] + arrayS2[j] + 1;
                    if(temp >=10){
                        result1[0] = 1;
                        result1[1] = temp % 10;
                        for(int k = 2 ; i <result1.length -1 ; i++){
                            result1[k] = result[k];
                        }
                    } else {
                        result[i] = temp % 10;
                    }
                } else {
                    int temp = arrayS1[i] + arrayS2[j];
                    if(temp >= 10){
                        result1 = new int[s1.length() + 1];
                        result1[0] = 1;
                        result1[1] = temp % 10;
                        for(int k = 2 ; i <result1.length -1 ; i++){
                            result1[k] = result[k];
                        }
                    } else {
                        result[i] = temp % 10;
                    }
                }
                System.out.println("Result 1: "+ Arrays.toString(result1));
            }
            else {
                int temp = arrayS1[i] + arrayS2[j];
                if(temp >= 10){
                    result[i] = temp % 10;
                    carry = true;
                } else {
                    result[i] = temp;
                    carry = false;
                }
            }

        }
//        if(result1)

//        return result.toString();
//        System.out.println("Result: "+ Arrays.toString(result));
        return "1234";
    }
}
