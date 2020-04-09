package com.raghvendra;

/**
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 *
 * A defanged IP address replaces every period "." with "[.]".
 *
 *
 *
 * Example 1:
 *
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 * Example 2:
 *
 * Input: address = "255.100.50.0"
 * Output: "255[.]100[.]50[.]0"
 *
 *
 * Constraints:
 *
 * The given address is a valid IPv4 address.
 */
public class DefangingAnIPAddress {
    /**
     * Approach 1:
     */
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }

    /**
     * Approach 2:
     */
    public String defangIPaddrII(String address) {
        return address.replaceAll("\\.","[.]");
    }

    /**
     * Approach 3:
     */
    public String defangIPaddrIII(String address) {
        return String.join("[.]", address.split("\\."));
    }

    /**
     * Approach 4:
     */
    public String defangIPaddrIV(String address) {
        StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) {
            sb.append(c == '.' ? "[.]" : c);
        }
        return sb.toString();
    }
}
