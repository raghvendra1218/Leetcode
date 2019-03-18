package com.raghvendra;

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
