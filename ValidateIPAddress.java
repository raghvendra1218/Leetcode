package com.raghvendra;
/*
Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers,
each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits.
The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one.
Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones,
so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).
However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity.
For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.

Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.

Note: You may assume there is no extra space or special characters in the input string.

Example 1:
Input: "172.16.254.1"

Output: "IPv4"

Explanation: This is a valid IPv4 address, return "IPv4".
Example 2:
Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"

Output: "IPv6"

Explanation: This is a valid IPv6 address, return "IPv6".
Example 3:
Input: "256.256.256.256"

Output: "Neither"

Explanation: This is neither a IPv4 address nor a IPv6 address.
 */

public class ValidateIPAddress {
    public String validIPAddress(String IP) {
        String ans = "Neither";
        //return the ans as it is if the string is null
        if(IP.length() == 0 || IP == null) return ans;
        //Check if the String IP contains : or . accordingly send to respective helper function
        if(IP.contains(".") && validIPv4(IP)){
            ans = "IPv4";
        } else if(IP.contains(":") && validIPv6(IP.toUpperCase())){
            ans = "IPv6";
        } else {
            ans = "Neither";
        }
        return ans;
    }

    private boolean validIPv4(String IP){
        int cnt = 0;
        for(char ch : IP.toCharArray()){
            if(ch == '.'){
                cnt++;
            }
        }
        if(cnt != 3) return false;
        String[] subnets = IP.split("\\.");
        //length of subnet in any case should always be of size 4
        if(subnets.length != 4) return false;
        //traverse through the array subnet to check if each element is in range of 0 to 255 and there are no leading zero
        for(String s : subnets){
            //check if the each subnet is not Empty and it's length is always less than 3.
            if(s.isEmpty() || s.length() > 3) return false;
            int sz = s.length();
            //validate each character inside the subnet is digit
            for(int i = 0; i < sz; ++i){
                if(!Character.isDigit(s.charAt(i))){
                    return false;
                }
            }
            if((s.charAt(0) == '0' && s.length() !=1) || Integer.valueOf(s) > 255 || Integer.valueOf(s) < 0) return false;
        }
        return true;
    }

    private boolean validIPv6(String IP){
        int cnt = 0;
        for(char ch : IP.toCharArray()){
            if(ch == ':'){
                cnt++;
            }
        }
        if(cnt != 7) return false;
        String[] subsets = IP.split(":");
        if(subsets.length != 8) return false;
        for(String s : subsets){
            if(s.isEmpty() || s.length() > 4) return false;
            for(int i = 0; i < s.length(); ++i){
                if(!Character.isDigit(s.charAt(i)) && (s.charAt(i) < 'A' || s.charAt(i) > 'F')){
                    return false;
                }
            }
        }
        return true;
    }
}
