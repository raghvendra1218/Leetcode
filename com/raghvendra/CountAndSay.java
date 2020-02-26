package com.raghvendra;

public class CountAndSay {
    public String countAndSay(int n) {
        int i = 1;
        String eachPattern ="1";
        while(i < n){
            eachPattern = pattern(eachPattern);
            i ++;
        }
        return eachPattern;
    }

    private String pattern(String x){
        StringBuilder pat = new StringBuilder();
        //below (commented)is maha chutiya approach which i took and tried to solve, it will create issue when number is too large and it will be difficult to handle that
//        int prevRem = x % 10;
//        x/=10;
//        int count = 1;
//        int rem = 0;
//        while(x!=0){
//            rem = x % 10;
//            if(rem == prevRem){
//                count++;
//            } else {
//                pat.insert(0,prevRem);
//                pat.insert(0,count);
//                prevRem = rem;
//                count = 1;
//            }
//            x/=10;
//        }
//        pat.insert(0,prevRem);
//        pat.insert(0,count);
        int i = 1;
        int count = 1;
        char number = x.charAt(0);
        while(i < x.length()){
            if(x.charAt(i-1) == x.charAt(i)){
                count++;
            }else {
                pat.append(count);
                pat.append(number);
                count = 1;
                number = x.charAt(i);
            }
            i++;
        }
        pat.append(count);
        pat.append(number);
        return new String(pat);
    }
}
