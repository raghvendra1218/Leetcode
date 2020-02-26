package com.raghvendra;

/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int i, row = 0, col = 0;
        int lastRow = result.length - 1;
        int lastCol = result[row].length - 1;
        int counter = 1;

        while(row <= lastRow && col <= lastCol){

            for(i = col; i <= lastCol; ++i){
                result[row][i] = counter;
                counter++;
            }
            row++;
            for(i = row; i<=lastRow; ++i){
                result[i][lastCol] = counter;
                counter++;
            }
            lastCol--;
            if(row <= lastRow){
                for(i=lastCol; i >=col; --i){
                    result[lastRow][i] = counter;
                    counter++;
                }
                lastRow--;
            }
            if(col <= lastCol){
                for(i = lastRow; i >=row; --i){
                    result[i][col] = counter;
                    counter++;
                }
            }
            col++;
        }
        return result;
    }
}
