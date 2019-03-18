package com.raghvendra;

public class BattleshipsInABoard {
    /**
     * Approach 1 : Using recursion (DFS Graph), here we are modifying the board
     * @param board
     * @return
     */
/*    public int countBattleships(char[][] board) {
        int numBattleShips = 0;
        int row = 0;
        int col = 0;
        for(row = 0; row < board.length; row++){
            for(col = 0; col < board[0].length; col++){
                if(board[row][col] == 'X'){
                    traverseBoard(row, col, board);
                    numBattleShips++;
                }
            }
        }
        return numBattleShips;
    }

    private void traverseBoard(int row, int col, char[][] board){
        int lastRow = board.length - 1;
        int lastCol = board[0].length - 1;

        //Check the base case for the recursion to break
        if(row < 0 || col < 0 || row > lastRow || col > lastCol || board[row][col] == '.'){
            return;
        }

        board[row][col] = '.';
        traverseBoard(row + 1, col, board);
        traverseBoard(row - 1, col, board);
        traverseBoard(row, col + 1, board);
        traverseBoard(row, col - 1, board);
    }*/

    /**
     * Approach 2: Here the board is not modified and Space Complexity is also O(1)
     * Intuition : Going over all cells, we can count only those that are the "first" cell of the battleship.
     * First cell will be defined as the most top-left cell.
     * We can check for first cells by only counting cells that do not have an 'X' to the left and do not have an 'X' above them.
     */
    public int countBattleships(char[][] board) {
        int row = 0;
        int col = 0;
        int numBattleShips = 0;
        int lastRow = board.length - 1;
        int lastCol = board[0].length - 1;

        for(row = 0; row <= lastRow; row++){
            for(col = 0; col <= lastCol; col++){
                if(board[row][col] == '.'){
                    continue;
                }
                if(row > 0 && board[row - 1][col] == 'X'){
                    continue;
                }
                if(col > 0 && board[row][col - 1] == 'X'){
                    continue;
                }
                numBattleShips++;
            }
        }
        return numBattleShips;
    }
}
