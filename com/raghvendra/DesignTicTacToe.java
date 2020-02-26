package com.raghvendra;

public class DesignTicTacToe {
    /** Initialize your data structure here. */
    //We will take the Row Counter and Column counter to keep track of the moves of each player
    //We will also store the count for diagonal elements using diagRight and diagLeft
    int [] rowCounter;
    int [] colCounter;
    int diagLeft = 0;
    int diagRight = 0;
    int n;
    public DesignTicTacToe(int n) {
        rowCounter = new int[n];
        colCounter = new int[n];
        this.n = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        //Assign the move as 1 for player 1 and -1 for Player 2
        int move = (player == 1) ? 1 : -1 ;
        rowCounter[row] = rowCounter[row] + move;
        colCounter[col] = colCounter[col] + move;
        if(row == col) diagLeft += move;
        if(row ==  n - 1 - col) diagRight += move;
        if(rowCounter[row] == n || colCounter[col] == n || diagRight == n || diagLeft == n) return 1;
        if(rowCounter[row] == -n || colCounter[col] == -n || diagRight == -n || diagLeft == -n) return 2;
        return 0;
    }
}
