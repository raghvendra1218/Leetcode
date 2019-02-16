package com.raghvendra;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length()-1, j = num2.length()-1;
        while(i>=0 || j>=0 || carry == 1){
            if(i >=0){
                carry = num1.charAt(i) -'0' + carry;
                i --;
            } else {
                carry+=0;
            }
            if(j >=0){
                carry = num2.charAt(j) -'0' + carry;
                j--;
            } else {
                carry+=0;
            }
            sb.append(carry % 10);
            carry /=10;
        }
        return new String(sb.reverse());
    }
}
