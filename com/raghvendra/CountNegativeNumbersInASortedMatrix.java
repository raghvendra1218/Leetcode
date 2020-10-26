package com.raghvendra;

public class CountNegativeNumbersInASortedMatrix {
    //Observation : The smallest element will be found at grid[m][n]
    public int countNegatives(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int lastRow = grid.length - 1;
        int lastCol = grid[0].length - 1;

        int count = 0;
        for(int i = lastRow; i >=0; --i){
           int start = 0;
           int end = lastCol;
            // check if the last element is non-negative then no need to traverse the row
            // we can safely break the loop, as the points above it will be all +ve and the points left to it will be all +ve
           if(grid[i][lastCol] > 0) break;
            while(start <= end) {
                int mid = start + (end - start)/2;
                if(grid[i][mid] < 0) {
                   count += end - mid + 1;
                   end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return count;
    }
}
