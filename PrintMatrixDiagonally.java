package com.raghvendra;

import java.util.ArrayList;
import java.util.List;

/*
[1 , 2 , 3 , 4 , 5
 6 , 7 , 8 , 9 , 10
 11, 12, 13, 14, 15
 16, 17, 18, 19, 20]

 We can see that there is a formula we can progress row wise
 formula is row --  and col ++  stop when row becomes zero every time when row is increased;
 1,
 6,2
 11,7,3
 16,12,8,4
 17,13,9,5
 18,14,10
 19,15
 20
 */

public class PrintMatrixDiagonally {
    public List<Integer> printDiagonally(int[][] nums){
        List<Integer> result = new ArrayList<>();
        int numRows = nums.length;
        int numCols = nums[0].length;
        int row = 0;
        int col = 0;
        //Print row wise Diagonals
        for(int k = 0; k < numRows; ++k){
            row = k;
            col = 0;
            while(row >= 0){
                result.add(nums[row][col]);
                row--;
                col++;
            }
        }
        //Print Column wise diagonals, start now k with 1, becoz we don't want middle diagonal to be printed twice
        for(int k = 1; k < numCols; ++k){
            row = numRows - 1;
            col = k;
            while(col < numCols){
                result.add(nums[row][col]);
                row--;
                col++;
            }
        }
        return result;
    }
}
