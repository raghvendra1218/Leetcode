package com.raghvendra;

public class SurroundedRegions {
    public void solve(char[][] board) {
        //Edge case
        if(board.length == 0 || board[0].length == 0) return;

        int numRows = board.length;
        int numCols = board[0].length;

        //Check the elements in first column and last column for 'O' and replace that with '*'
        for(int i = 0; i < numRows; ++i){
            if(board[i][0] == 'O')dfsTraversal(board, i, 0);
            if(board[i][numCols - 1] == 'O')dfsTraversal(board, i, numCols - 1);
        }

        //Check for the elements in the first row and last row for 'O' and replace it with '*'
        for(int j = 0; j < numCols; ++j){
            if(board[0][j] == 'O')dfsTraversal(board, 0, j);
            if(board[numRows - 1][j] == 'O')dfsTraversal(board, numRows - 1, j);
        }

        //Traverse through the board and replace every 'O' --> 'X' and '*' --> 'O'
        for(int i = 0; i < numRows; ++i){
            for(int j = 0; j < numCols; ++j){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }

    private void dfsTraversal(char[][] board, int row, int col){
        int numRows = board.length;
        int numCols = board[0].length;

        //Base case or Exit case
        if(row < 0 || col < 0 || row > numRows - 1 || col > numCols - 1 || board[row][col] != 'O'){
            return;
        }
//        if(board[row][col] == 'X' || board[row][col] == '*') return;
        board[row][col] = '*';
        dfsTraversal(board, row + 1, col);
        dfsTraversal(board, row - 1, col);
        dfsTraversal(board, row, col + 1);
        dfsTraversal(board, row, col - 1);
    }
}
