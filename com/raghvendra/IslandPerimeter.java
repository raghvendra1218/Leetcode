package com.raghvendra;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        if(grid == null || grid.length == 0) return perimeter;
        int lastRow = grid.length - 1;
        int lastCol = grid[0].length - 1;
        for(int row = 0; row <= lastRow; ++row) {
            for(int col = 0; col <= lastCol; ++col) {
                //Case when I am standing on land
                if(grid[row][col] == 1) {
                    //UP
                    if(row == 0 || grid[row - 1][col] == 0) perimeter++;
                    //LEFT
                    if(col == 0 || grid[row][col - 1] == 0) perimeter++;
                    //RIGHT
                    if(col == lastCol || grid[row][col + 1] == 0) perimeter++;
                    //DOWN
                    if(row == lastRow || grid[row + 1][col] == 0) perimeter++;
                }
            }
        }
        return perimeter;
    }
}
