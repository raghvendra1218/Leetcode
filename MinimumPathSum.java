package com.raghvendra;


public class MinimumPathSum {
    /**
     * Approach 1:  Simple Recursion : Time Limit exceeds, but solution is correct.
     */
/*    int minWeight = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        int row = 0;
        int col = 0;
        minWeight = recurse(grid,row,col);
        return minWeight;
    }

    private int recurse(int[][] grid, int row, int col){
        //This is the boundary checking condition for the matrix because we need to stop the recursion at the three points:
        // One, when the either row reaches at the end of the row, then we will simply return the Integer.Max_VALUE, because we have to find the minimum path sum
        // Second, when the either row reaches at the end of the col, then we will simply return the Integer.Max_VALUE, because we have to find the minimum path sum
        // Third, when row and col reaches at the last element of the matrix i.e grid[m][n], where we will return value at that point
        if(row == grid.length || col == grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if((row == grid.length - 1) && (col == grid[0].length-1)){
            return grid[row][col];
        }
        return grid[row][col] + Math.min(recurse(grid, row + 1, col), recurse(grid, row, col + 1));
    }*/

    /**
     * Approach 2:  Recursion + Memoization.
     */
    int minWeight = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        int row = 0;
        int col = 0;
        int[][] memo = new int[grid.length][grid[0].length];
        for(int i = 0 ; i < memo.length; ++i){
            for(int j = 0; j < memo[0].length; ++j){
                memo[i][j] = -1;
            }
        }
        minWeight = recurse(grid,row,col, memo);
        return minWeight;
    }

    private int recurse(int[][] grid, int row, int col, int[][] memo){
        //This is the boundary checking condition for the matrix because we need to stop the recursion at the three points:
        // One, when the either row reaches at the end of the row, then we will simply return the Integer.Max_VALUE, because we have to find the minimum path sum
        // Second, when the either row reaches at the end of the col, then we will simply return the Integer.Max_VALUE, because we have to find the minimum path sum
        // Third, when row and col reaches at the last element of the matrix i.e grid[m][n], where we will return value at that point
        // We will create another matrix of same size as given matrix fill it with -1 (becoz original matrix contains non -negative number)
        // now fill the values of memo with recursion if not present if present return the memo[row][col].
        if(row == grid.length || col == grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if((row == grid.length - 1) && (col == grid[0].length-1)){
            return grid[row][col];
        }
        if(memo[row][col] == -1){
            memo[row][col] = grid[row][col] + Math.min(recurse(grid, row + 1, col,memo), recurse(grid, row, col + 1,memo));
        }
        return memo[row][col];
    }
}
