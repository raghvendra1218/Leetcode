package com.raghvendra;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 *
 * Input: m = 7, n = 3
 * Output: 28
 *
 * Approach 1: Dynamic Programming
 * Intuition, Take an auxiliary matrix of same size and initialise the first row and col by 1 because total number of ways to reach each cell in first row and col
 * is just one because move can be made either in right or down option for reaching using down direction is not possible here (in first row and col)
 * for subsequent cells we will calculate the number of ways using matrix[row][col] = matrix[row-1][col] + matrix[row][col - 1]
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if(n == 1 || m == 1) return 1;

        int[][] auxliary =  new int[m][n];

        //initializing first col with 1
        for(int i = 0; i < m; i++){
            auxliary[i][0] = 1;
        }
        //initializing first col with 1
        for(int i = 0; i < n; i++){
            auxliary[0][i] = 1;
        }

        for(int row = 1; row < m ; row++){
            for(int col = 1; col < n ; col++){
                auxliary[row][col] = auxliary[row -1][col] + auxliary[row][col -1];
            }
        }
        return auxliary[m][n];
    }
}
