package com.raghvendra;

public class PathWithMaximumGold {
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        int lastCol = grid[0].length;
        int lastRow = grid.length;
        boolean[][] visited = new boolean[lastRow][lastCol];
        for (int row = 0; row < lastRow; ++row) {
            for (int col = 0; col < lastCol; ++col) {
                // check if cell value is zero, then skip
                if (grid[row][col] != 0) {
                    // traverse the grid to calculate max gold amount
                    maxGold = Math.max(dfs(row, col, visited, grid), maxGold);
                }
            }
        }
        return maxGold;
    }

    private int dfs(int row, int col, boolean[][] visited, int[][] grid) {
        int currentMaxGold = 0;
        int lastCol = grid[0].length;
        int lastRow = grid.length;

        // check the boundary of grid
        if (row < 0 || col < 0 || row >= lastRow || col >= lastCol || visited[row][col] || grid[row][col] == 0) {
            return 0;
        }

        visited[row][col] = true;
        currentMaxGold += grid[row][col];
        currentMaxGold += Math.max(Math.max(dfs(row + 1, col, visited, grid), dfs(row - 1, col, visited, grid)), Math.max(dfs(row, col + 1, visited, grid), dfs(row, col - 1, visited, grid)));
        visited[row][col] = false;
        return currentMaxGold;
    }
}
