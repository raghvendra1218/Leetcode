package com.raghvendra;

public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        //If length of matrix is 0 then return false;
        if(matrix.length == 0) return false;
        //navigate to the corner element in the Matrix and then check if the target element matches this element:
        //If yes return true;
        //else if target is less than the element at row,lastCol decrement lastCol
        //else if target is greater than the element at row,lastCol increment row
        //Continue this till row is less than lastRow and lastCol is greater than or equal to zero
        int lastCol = matrix[0].length - 1;
        int row = 0;
        while(row < matrix.length && lastCol >=0){
            if(target == matrix[row][lastCol]) return true;
            else if(target < matrix[row][lastCol]) lastCol--;
            else if(target > matrix[row][lastCol]) row++;
        }
        return false;
    }
}
