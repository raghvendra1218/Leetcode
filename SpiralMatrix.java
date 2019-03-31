package com.raghvendra;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0) return result;
        //Take four variables to traverse the matrix
        int i, row = 0, col = 0;
        int lastRow = matrix.length - 1;
        int lastCol = matrix[row].length - 1;

        //Check till the row and col is less than lastRow and lasCol resp.
        while(row <= lastRow && col <= lastCol){
            //Traverse from left to right
            for(i = col; i<=lastCol; ++i){
                result.add(matrix[row][i]);
            }
            //Advance the row by one
            row++;
            //Traverse from top to bottom
            for(i = row; i<=lastRow; ++i){
                result.add(matrix[i][lastCol]);
            }
            //Decrease the lastCol by 1
            lastCol--;
            //Traverse from right to left
            if(row <= lastRow){
                for(i = lastCol; i >= col; --i){
                    result.add(matrix[lastRow][i]);
                }
                //Decrease the lasRow by 1
                lastRow--;
            }
            //Traverse from bottom to top
            if(col <= lastCol){
                for(i = lastRow; i >=row; --i){
                    result.add(matrix[i][col]);
                }
                //Increase the col by 1
                col++;
            }

        }
        return result;
    }
}
