package com.raghvendra;
/*
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1)
and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
Note:
You may assume that the matrix does not change.
There are many calls to sumRegion function.
You may assume that row1 ≤ row2 and col1 ≤ col2.

 */

/**
 * Approach 1: Brute Force
 */
public class RangeSumQuery2DImmutable {

/*    private int[][] matrix;
    public RangeSumQuery2DImmutable(int[][] matrix) {
        if(matrix.length == 0) return;
        this.matrix = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; ++i){
            for (int j = 0; j < matrix[0].length; ++j){
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1; i <= row2; ++i){
            for(int j = col1; j <= col2; ++j){
                sum += this.matrix[i][j];
            }
        }
        return sum;
    }*/

    /**
     * Approach 2: Caching Smarter
     * We took the cumulative sum of Each row and col and have stored in each cell using a cache matrix, or DP matrix
     */
    private int[][] dp;
    public RangeSumQuery2DImmutable(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c];
            }
        }
//        System.out.println(Arrays.deepToString(dp));
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
}
