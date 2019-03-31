package com.raghvendra;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 *
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */

public class NumberOfIslands {
    private int numberOfIslands = 0;
    public int numIslands(char[][] grid) {
        int row = 0;
        int col = 0;
        for(row = 0; row < grid.length; ++row){
            for(col = 0; col < grid[0].length; ++col){
                if(grid[row][col] == '1'){
                    traverseIsland(row, col, grid);
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;
    }

    private void traverseIsland(int row, int col, char[][] grid){
        int lastRow = grid.length - 1;
        int lastCol = grid[0].length - 1;

        //Base case (or the input case where we have to return or break from recursion below)
        if(row < 0 || col < 0 || row > lastRow || col > lastCol || grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0';
        traverseIsland(row + 1, col, grid);
        traverseIsland(row - 1, col, grid);
        traverseIsland(row, col + 1, grid);
        traverseIsland(row, col - 1, grid);
    }
}
