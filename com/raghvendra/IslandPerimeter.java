package com.raghvendra;

/**
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
 * and there is exactly one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 *
 * Example:
 *
 * Input:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * Output: 16
 */
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
