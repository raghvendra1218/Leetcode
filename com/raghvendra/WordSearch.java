package com.raghvendra;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are
 * those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int row = 0;
        int col = 0;
        int pos = 0;
        boolean [][] map = new boolean[board.length][board[0].length];
        for(row = 0; row < board.length; ++ row){
            for(col = 0; col < board[0].length; ++col){
                if(traverse(row, col, pos, map, board, word)) return true;
            }
        }
        return false;
    }

    private boolean traverse(int row, int col, int pos, boolean [][] map, char[][] board, String word){
        int lastRow = board.length - 1;
        int lastCol = board[0].length - 1;

        //checking if pos reaches till the end of the word's length
        if(pos == word.length()){
            return true;
        }

        //Breaking conditions
        //check if the row and col does not overflow
        if(row < 0 || col < 0 || row > lastRow || col > lastCol){
            return false;
        }

        //check if the character is already taken, pos reaches at the end of the word string,
        if(map[row][col] || board[row][col] != word.charAt(pos)){
            return false;
        }

        //Assuming the element is used once , hence mark the character element as used
        map[row][col] = true;

        //Store the value of the exist in one boolean to return from function
        boolean exist = traverse(row - 1, col, pos + 1 ,map, board, word) ||
                        traverse(row, col + 1, pos + 1 ,map, board, word)  ||
                        traverse(row + 1, col, pos + 1 ,map, board, word) ||
                        traverse(row, col - 1, pos + 1 ,map, board, word);

        map[row][col] = false;

        //return the exist value
        return exist;
    }
}
