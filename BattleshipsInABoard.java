package com.raghvendra;


/**
 * Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
 * You receive a valid board, made of only battleships or empty slots.
 * Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
 * At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
 * Example:
 * X..X
 * ...X
 * ...X
 * In the above board there are 2 battleships.
 * Invalid Example:
 * ...X
 * XXXX
 * ...X
 * This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
 * Follow up:
 * Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?
 */


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
