package com.raghvendra;

import java.util.Arrays;

public class StringCompression {
    public int compress(char[] chars) {
        int count = 1; int index = 0;
        int i =0; int j =1;
        while(j< chars.length-1){
            if(chars[i] == chars[j]){
                count++;
            } else {
                chars[index] = chars[i];
                index++;
                if(count >=10){
                    int rem = 0;
                    while(count !=0){
                        rem = count % 10;

                    }
                } else {
                    if(count !=1){
                        chars[index] = (char)(count +'0');
                        index++;
                    }
                    count =1;
                }

            }
            i++;
            j++;
        }
        chars[index] = chars[i];
        index++;
        if(count >=10){
            int rem = 0;
            while(count !=0){
                rem = count % 10;

            }
        } else {
            if(count !=1){
                chars[index] = (char)(count +'0');
                index++;
            }
        }
        System.out.println("Array:"+ Arrays.toString(chars));
        return index+1;
    }
}
