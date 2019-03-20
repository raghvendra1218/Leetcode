package com.raghvendra;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {

    private Set<Integer> shape;
    private int hashValue = 2;
    public int numDistinctIslands(int[][] grid) {
        int row  = 0;
        int col = 0;
        int lastRow = grid.length - 1;
        int lastCol = grid[0].length - 1;
        //to keep the number of distinct shapes
        Set<Set<Integer>> shapes = new HashSet<>();

//        boolean [][] isVisited = new boolean[grid.length][grid[0].length];

        for(row = 0; row <=lastRow; row++){
            for(col = 0; col <=lastCol; col++){
//                if(!isVisited[row][col] && grid[row][col] == 1){
                if(grid[row][col] == 1){
                    shape = new HashSet<>();
//                    traverseIsland(row, col, row, col, isVisited, grid);
                    traverseIsland(row, col, row, col, grid);
                    shapes.add(shape);
                }
            }
        }
        return shapes.size();
    }

//    private void traverseIsland(int row, int col, int row0, int col0, boolean[][] isVisited, int[][] grid){
    private void traverseIsland(int row, int col, int row0, int col0, int[][] grid){
        int lastRow = grid.length - 1;
        int lastCol = grid[0].length - 1;

        //Base Case
//        if(row < 0 || col < 0 || row > lastRow || col > lastCol || isVisited[row][col] || grid[row][col] == 0){
        if(row < 0 || col < 0 || row > lastRow || col > lastCol || grid[row][col] == 0){
            return;
        }
//        isVisited[row][col] = true;
        grid[row][col] = 0;
        shape.add((row - row0) * hashValue * grid[0].length + (col - col0));

//        traverseIsland(row + 1, col, row0, col0, isVisited, grid);
//        traverseIsland(row - 1, col, row0, col0, isVisited, grid);
//        traverseIsland(row, col + 1, row0, col0, isVisited, grid);
//        traverseIsland(row, col - 1, row0, col0, isVisited, grid);
        traverseIsland(row + 1, col, row0, col0, grid);
        traverseIsland(row - 1, col, row0, col0, grid);
        traverseIsland(row, col + 1, row0, col0, grid);
        traverseIsland(row, col - 1, row0, col0, grid);
    }
}
