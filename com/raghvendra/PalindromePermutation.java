package com.raghvendra;

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        int sum = 0;
        int[] chars = new int[255];

        for(int i = 0; i < s.length(); ++i){
            chars[s.charAt(i)]++;
        }
//        Arrays.stream(chars).forEach(c -> c*2);
        for(int j =0; j<chars.length; ++j){
            chars[j] %= 2;
            sum+=chars[j];
        }
        if(sum == 0 || sum == 1) return true;
        return false;
    }

    /*
    Second Approach : Using Map
     */

//    public boolean canPermutePalindrome(String s) {
//        HashMap< Character, Integer > map = new HashMap < > ();
//        for (int i = 0; i < s.length(); i++) {
//            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
//        }
//        int count = 0;
//        for (char key: map.keySet()) {
//            count += map.get(key) % 2;
//        }
//        return count <= 1;
//    }

    /*
    Third Approach : Traversing once and updating the count on the fly
     */

//    public boolean canPermutePalindrome(String s) {
//        int[] map = new int[128];
//        int count = 0;
//        for (int i = 0; i < s.length(); i++) {
//            map[s.charAt(i)]++;
//            if (map[s.charAt(i)] % 2 == 0)    //every time the count is made to 1 for that character, that we are doing through second traversal for char array and taking %2 for each element
//                count--;
//            else
//                count++;
//        }
//        return count <= 1;
//    }
}
