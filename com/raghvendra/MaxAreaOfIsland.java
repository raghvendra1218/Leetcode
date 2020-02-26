package com.raghvendra;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 *
 * Example 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 *
 * Example 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 * Note: The length of each dimension in the given grid does not exceed 50.
 */

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int row = 0;
        int col = 0;
        int maxArea = 0;
        int lastRow = grid.length - 1;
        int lastCol = grid[0].length - 1;
        int [][] map = new int[grid.length][grid[0].length];
        for(row = 0; row <= lastRow; row++){
            for( col = 0; col <= lastCol; col++){
                if( map[row][col] == 0 && grid[row][col] == 1){
                    maxArea = Math.max(maxArea, traverseIsland(grid, row, col, map));
                }
            }
        }
        return maxArea;
    }

    private int area = 0;
    private int traverseIsland(int[][] grid, int row, int col, int[][] map){
        int lastRow = grid.length - 1;
        int lastCol = grid[0].length - 1;

        //Base case
        if(row < 0 || col < 0 || row > lastRow || col > lastCol || grid[row][col] == 0 || map[row][col] == -1){
            return 0;
        }

        map[row][col] = -1;
        area = grid[row][col] + (traverseIsland(grid, row + 1, col, map) + traverseIsland(grid, row - 1, col, map)
                + traverseIsland(grid, row, col + 1, map) + traverseIsland(grid, row, col - 1, map));

        return area;
    }
}
