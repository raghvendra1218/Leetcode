package com.raghvendra;

public class ValidTicTacToeState {
    public boolean validTicTacToe(String[] board) {
        int length = board.length;
        //We cannot use below commented line for calculating the lastIndex of column because String can be empty in that case
        //board[0].length will be 0;
//        int lastIndex = board[0].length() -1;
        int lastIndex = length -1;  //safe to use rather than above

        int [] rowCounter = new int[length];
        int [] colCounter = new int[length];

        int turns = 0;
        int diagCount = 0;
        int antiDiagCount = 0;

        boolean xWins = false;
        boolean oWins = false;

        for(int i = 0; i <length; ++i){
            for(int j = 0; j < length; ++j){

                char c = board[i].charAt(j);

                if(c == 'X'){
                    turns++;
                    rowCounter[i]++;
                    colCounter[j]++;

                    if(i == j) diagCount++;
                    if(i == lastIndex - j) antiDiagCount++;
                } else if( c == 'O'){
                    turns--;
                    rowCounter[i]--;
                    colCounter[j]--;
                    if(i == j) diagCount--;
                    if(i == lastIndex - j) antiDiagCount--;
                }
            }
        }

        //traverse through each row and check if sum of rowCounter is equal to length, if yes then set X wins to true
        boolean xWinsByRows = false;
        for(int i = 0; i<length; ++i){
            if(rowCounter[i] == length) xWinsByRows = true;
        }

        //traverse through each col and check if sum of colCounter is equal to length, if yes then set X wins to true
        boolean xWinsByCols = false;
        for(int i = 0; i<length; ++i){
            if(colCounter[i] == length) xWinsByCols = true;
        }

        //traverse through each row and check if sum of rowCounter is equal to -length, if yes then set Y wins to true
        boolean oWinsByRows = false;
        for(int i =0; i<length; ++i){
            if(rowCounter[i] == -length) oWinsByRows = true;
        }

        //traverse through each col and check if sum of colCounter is equal to -length, if yes then set Y wins to true
        boolean oWinsByCols = false;
        for(int i =0; i<length; ++i){
            if(colCounter[i] == -length) oWinsByCols = true;
        }

        //check if the diagCount or antiDiagCount is equal to length, if yes set xWins to true
        boolean xWinsbyDiagOrAntiDiag = diagCount == length || antiDiagCount == length;

        //check if the diagCount or antiDiagCount is equal to length, if yes set xWins to true
        boolean oWinsbyDiagOrAntiDiag = diagCount == -length || antiDiagCount == -length;

        xWins = xWinsByRows || xWinsByCols || xWinsbyDiagOrAntiDiag;
        oWins = oWinsByRows || oWinsByCols || oWinsbyDiagOrAntiDiag;

        //Check if the xWins and turn is 0 that means it's invalid state and vice-versa for oWins (because since x starts,
        // turns should always be 1 if X wins OR turns should always be zero if O wins.
        boolean turnsInvalid = xWins && turns == 0 || oWins && turns == 1;
        if(turnsInvalid) return false;

        boolean findFinalTurnCount = turns ==1 || turns == 0;
        boolean onlyOnePartyWins = !xWins || !oWins;

        return findFinalTurnCount && onlyOnePartyWins;
    }
}
