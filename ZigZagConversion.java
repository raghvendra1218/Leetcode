package com.raghvendra;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(s == null || s.length() < 2 || numRows < 2 || s.length() < numRows){
            return s;
        }

        List<StringBuilder> list = new ArrayList<>();
        int index = 0;
        boolean isGoingDown = false;

        //Initializing the list with the StringBuilder
        for(int i = 0; i < numRows; ++i){
            list.add(new StringBuilder());
        }

        for(int i = 0; i < s.length(); ++i){
            list.get(index).append(s.charAt(i));

            if(isGoingDown){
                if(index == numRows - 1){
                    index = numRows - 2 ; //initialize the index to one row prior to the last row in descending order becoz we ant to form zig-zag
                    isGoingDown = false;
                } else{
                    index++;
                }
            } else{
                if(index == 0){
                    index = 1;
                    isGoingDown = true;
                } else{
                    index--;
                }
            }
        }

        //Traverse through the list and accumulate in one String that is our answer
        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : list){
            res.append(sb);
        }
        return res.toString();
    }
}
