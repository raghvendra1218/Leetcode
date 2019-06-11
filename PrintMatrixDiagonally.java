package com.raghvendra;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrixDiagonally {
    public List<Integer> printDiagonally(int[][] nums){
        List<Integer> result = new ArrayList<>();
        int numRows = nums.length;
        int numCols = nums[0].length;
        int row = 0;
        int col = 0;

        for(int k = 0; k < numRows; ++k){
            row = k;
            col = 0;
            while(row >= 0){
                result.add(nums[row][col]);
                row--;
                col++;
            }
        }

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
