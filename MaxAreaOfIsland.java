package com.raghvendra;

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
