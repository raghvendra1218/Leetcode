package com.raghvendra;

import java.util.Arrays;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int row  = 0;
        int col = 0;
        int [][] map = new int[board.length][board[0].length];
        for(row = 0; row < board.length; ++row){
            for(col = 0; col < board[0].length; ++col){
                int state  = board[row][col];

                int numNeighbors = count(row, col, board);
                map[row][col] = state;

                if((numNeighbors < 2 || numNeighbors > 3)){
                     map[row][col] = 0;
                 } else if(state == 0 && numNeighbors == 3) {
                     map[row][col] = 1;
                 }
            }
        }
        for(row = 0; row < map.length ; row++){
            for(col = 0; col < map[0].length; col++){
                board[row][col] = map[row][col];
            }
        }
        System.out.print(Arrays.deepToString(map));
    }

    private int count(int row, int col, int [][] board){
        //Edges
        int  startRow = -1;
        int startCol = -1;
        int endRow = 2, endCol = 2;
        if(row == 0 ){
            startRow = 0;
        }
        if (col == 0){
            startCol = 0;
        }
        if(row == board.length - 1){
            endRow = 1;
        }
        if(col == board[0].length - 1){
            endCol = 1;
        }
        int sum = 0;
        for(int i = startRow; i < endRow; i++){
            for(int j = startCol; j < endCol; ++j){
                sum += board[row + i][col + j];
            }
        }
        sum -= board[row][col];
        return sum;
    }
}
