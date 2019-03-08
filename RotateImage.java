package com.raghvendra;

import java.util.Arrays;
import java.util.Collections;

public class RotateImage {
    public void rotate(int[][] matrix) {
        Collections.reverse(Arrays.asList(matrix));
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < i; ++j){
                swap(matrix,i, j);
            }
        }

    }

    private void swap (int[][] matrix, int a, int b) {
        int temp = matrix[a][b];
        matrix[a][b] = matrix[b][a];
        matrix[b][a] = temp;
    }
    /**
     * Approach 2:  Could be Taking Transpose first and then reverse the elements in each row
     */
    //Reverse program can also be written in O(n^2) Complexity:
/*      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n / 2; j++) {
            int tmp = matrix[i][j];
            matrix[i][j] = matrix[i][n - j - 1];
            matrix[i][n - j - 1] = tmp;
        }
    }*/
}
