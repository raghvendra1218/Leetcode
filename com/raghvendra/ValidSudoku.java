package com.raghvendra;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        for(int row = 0;  row < board.length ; row++){
            Set<Character> rowSet =  new HashSet<>(9);
            Set<Character> colSet = new HashSet<>(9);
            Set<Character> squareSet = new HashSet<>(9);
            for(int col = 0; col < board[0].length; col++){

                int u = ((row / 3) * 3) + (col % 3);
                int v = ((row % 3) * 3) + (col / 3);

                if(rowSet.contains(board[row][col]) ||
                    colSet.contains(board[col][row]) ||
                    squareSet.contains(board[u][v])){
                    return false;
                }

                if(board[row][col] != '.') rowSet.add(board[row][col]);
                if(board[col][row] != '.') colSet.add(board[col][row]);
                if(board[u][v] != '.') squareSet.add(board[u][v]);
            }
        }
        return true;
    }
}
