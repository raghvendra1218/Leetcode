package com.raghvendra;

/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */

public class AddBinary {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        char[] strA = a.toCharArray();
        char[] strB = b.toCharArray();
        int i = strA.length-1;
        int j = strB.length-1;
        while(i>=0 || j>=0 || carry == 1){
//            carry += i >=0 ? strA[i--] -'0': 0;
            if(i >=0){
                carry = carry + strA[i] - '0';
                i--;
            } else {
                carry+=0;
            }
            if(j >=0){
                carry = carry + strB[j] - '0';
                j--;
            } else {
                carry+=0;
            }
//            carry += j >=0 ? strB[j--] -'0': 0;
            sb.append((carry % 2));
            carry /= 2;
        }

//            if(i >=0){
//                carry = carry + strA[i] -'0';
//                System.out.println("carry : "+ carry);
//                i--;
//            } else {
//                carry = carry + 0;
//            }

//            if(j >=0){
//                carry = carry + strB[j] -'0';
//                System.out.println("carry : "+ carry);
//                j--;
//            } else {
//                carry = 0;
//            }
//        int temp = 0;
//        StringBuilder sb = new StringBuilder("");
//        boolean carry = false;
//        while(i >= 0 && j >= 0){
//            if(strA[i] == '1' && strB[j] == '1'){
//                if(carry){
//                    temp = (strA[i]-'0') ^ (strB[j]-'0') ^1;
//                    sb.append(temp);
//                    carry = true;
//                } else {
//                    temp = (strA[i]-'0') ^ (strB[j]-'0');
//                    sb.append(temp);
//                    carry =true;
//                }
//            }
//            else if((strA[i] == '0' && strB[j] =='1') || (strA[i] == '1' && strB[j] == '0')){
//                if(carry){
//                    temp = (strA[i]-'0') ^ (strB[j]-'0') ^1;
//                    sb.append(temp);
//                    carry = true;
//                } else {
//                    temp = (strA[i]-'0') ^ (strB[j]-'0');
//                    sb.append(temp);
//                    carry = false;
//                }
//            } else {
//                if(carry){
//                    temp = (strA[i]-'0') ^ (strB[j]-'0') ^ 1;
//                    sb.append(temp);
//                    carry = false;
//                } else {
//                    temp = (strA[i]-'0') ^ (strB[j]-'0') ;
//                    sb.append(temp);
//                    carry = false;
//                }
//            }
//            i --;
//            j --;
//        }
//        while(i >= 0){
//            if(strA[i] == '1'){
//                if(carry){
//                    temp = (strA[i]-'0') ^ 1;
//                    sb.append(temp);
//                    carry = true;
//                } else {
//                    temp = (strA[i]-'0');
//                    sb.append(temp);
//                    carry =false;
//                }
//
//            }else {
//                if(carry) {
//                    temp = (strA[i] - '0') ^ 1;
//                    sb.append(temp);
//                    carry = false;
//                } else {
//                    temp = (strA[i]-'0');
//                    sb.append(temp);
//                    carry =false;
//                }
//            }
//            i --;
//        }
//        while(j >= 0){
//            if(strB[j] == '1'){
//                if(carry){
//                    temp = (strB[j]-'0') ^ 1;
//                    sb.append(temp);
//                    carry = true;
//                } else {
//                    temp = (strB[j]-'0');
//                    sb.append(temp);
//                    carry =false;
//                }
//
//            }else {
//                if(carry) {
//                    temp = (strB[j] - '0') ^ 1;
//                    sb.append(temp);
//                    carry = false;
//                } else {
//                    temp = (strB[j]-'0');
//                    sb.append(temp);
//                    carry =false;
//                }
//            }
//            j --;
//        }
        return new String(sb.reverse());
    }
}
