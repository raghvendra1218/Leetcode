package com.raghvendra;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
 */

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
