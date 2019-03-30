package com.raghvendra;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 *
 * Approach : Dynamic Programming
 * Intuition: Take an auxiliary matrix of same size and initialise the first row and col by 1 because total number of ways to reach each cell in first row and col
 * is just one because move can be made either in right or down option for reaching using down direction is not possible here (in first row and col)
 * for subsequent cells we will calculate the number of ways using matrix[row][col] = matrix[row-1][col] + matrix[row][col - 1].
 * If obstacle mark that cell with 0.
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;

        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;

        int[][] auxiliary = new int[height][width];

        //Traverse the first col and fill that with 1 or 0 .
        for(int firstRow = 0; firstRow < height; firstRow ++){
            if(obstacleGrid[firstRow][0] != 1){
                auxiliary[firstRow][0] = 1;
            } else {
                //break the loop because once encountered an obstacle there will be no further path
                break;
            }
        }

        //Traverse the first row and fill that with 1 or 0 (if obstacle).
        for(int firstCol = 0; firstCol < width; ++ firstCol){
            if(obstacleGrid[0][firstCol] != 1){
                auxiliary[0][firstCol] = 1;
            } else {
                //break the loop because once encountered an obstacle there will be no further path
                break;
            }
        }

        //Traverse the rest of the Obstacle Grid
        for(int row = 1; row < height; row++){
            for(int col = 1; col < width; col++){
                if(obstacleGrid[row][col] != 1){
                    auxiliary[row][col] = auxiliary[row - 1][col] + auxiliary[row][col - 1];
                } else {
                    // there is obstacle
                    auxiliary[row][col] = 0;
                }
            }
        }
        return auxiliary[height -1][width -1];
    }
}
