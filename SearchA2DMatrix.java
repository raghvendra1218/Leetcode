package com.raghvendra;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, lasCol = matrix[0].length - 1;
        while(row < matrix.length -1 && lasCol >= 0){
            if(matrix[row][lasCol] == target) return true;
            else if(target > matrix[row][lasCol]) row++;
            else  if(target < matrix[row][lasCol]) lasCol--;
        }
        return false;
    }
}