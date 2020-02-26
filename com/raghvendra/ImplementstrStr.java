package com.raghvendra;

//public class ImplementstrStr {
//    //Run time : 346ms
//    public int strStr(String haystack, String needle) {
//        int needleLength = needle.length();
//        if(needleLength == 0) return 0;
//        if(needleLength > haystack.length()) return -1;
//        int count = 0;
//        char[] chars = haystack.toCharArray();
//        for(int i = 0; i <chars.length; i++){
//            int temp = i;
//            for(int j = 0; j < needleLength && i<chars.length; j++){  //mississippi  //issipi
//                if(chars[i] == needle.charAt(j)){
//                    System.out.println(needle.charAt(j));
//                    count++;
//                    i++;
//                } else {
//                    break;
//                }
//            }
//            i = temp;
//            if(count == needleLength) return temp;
//            count = 0;
//        }
//        return -1;
//    }
//}

// Optimised approach
public class ImplementstrStr {
    //Run time : 3ms
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        for(int i = 0; i < haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(i+needle.length() > haystack.length()) return -1;
                if(haystack.substring(i, i + needle.length()).equals(needle)) return i;
            }
        }
        return -1;
    }
}