package com.raghvendra;

public class FindWinnerOnATicTacToeGame {
    public String tictactoe(int[][] moves) {
        int[] aRow = new int[3];
        int[] aCol = new int[3];
        int[] bRow = new int[3];
        int[] bCol = new int[3];
        int aDiag = 0;      // case where r == c , r is row and c is column
        int aAntiDiag = 0;  // case when r + c == (n - 1) , n is the number of rows/cols of a square matrix, n = 3 here
        int bDiag = 0;
        int bAntiDiag = 0;

        // traverse through moves array
        for (int i = 0; i < moves.length; ++i) {
            int r = moves[i][0];
            int c = moves[i][1];

            // A moves
            if (i % 2 == 0) {
                // condition where A wins
                if(++aRow[r] == 3 || ++aCol[c] == 3 || r == c && ++aDiag == 3 || r + c == 2 && ++aAntiDiag == 3) return "A";
            } else { // B moves
                // condition where B wins
                if(++bRow[r] == 3 || ++bCol[c] == 3 || r == c && ++bDiag == 3 || r + c ==2 && ++bAntiDiag == 3) return "B";
            }
        }

        // if moves length is 9 that means both have completed the board game, still we did not found teh winner, that means
        // Game is draw, otherwise if the moves length is not 9 , that means that game is pending.
        return (moves.length == 9) ? "Draw" : "Pending";
    }

}
