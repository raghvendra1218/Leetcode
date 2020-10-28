package com.raghvendra;

public class SurfaceAreaOf3DShapes {
    public int surfaceArea(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int lastRow = grid.length - 1;
        int lastCol = grid[0].length - 1;
        int[] x = new int[]{0, 0, -1, 1};
        int[] y = new int[]{-1, 1, 0, 0};
        int surfaceArea = 0;

        // traverse through grid
        for (int i = 0; i <= lastRow; ++i) {
            for (int j = 0; j <= lastCol; ++j) {
                if(grid[i][j] > 0) {
                    surfaceArea += 2;  //Adding the top surface and bottom surface area
                    for (int k = 0; k < x.length; ++k) {
                        int row = i + x[k];
                        int col = j + y[k];
                        int temp = 0;

                        // Check if the point lies inside the grid
                        if (isInside(row, col, grid)) {
                            temp = grid[row][col];
                        }

                        surfaceArea += Math.max(0, grid[i][j] - temp);
                    }
                }
            }
        }

        return surfaceArea;
    }

    private boolean isInside(int i, int j, int[][] grid) {
        int lastRow = grid.length - 1;
        int lastCol = grid[0].length - 1;
        return i >= 0 && j >= 0 && i <= lastRow && j <= lastCol;
    }
}
