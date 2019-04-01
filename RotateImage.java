package com.raghvendra;
/**
 You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Note:

 You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 DO NOT allocate another 2D matrix and do the rotation.

 Example 1:

 Given input matrix =
 [
 [1,2,3],
 [4,5,6],
 [7,8,9]
 ],

 rotate the input matrix in-place such that it becomes:
 [
 [7,4,1],
 [8,5,2],
 [9,6,3]
 ]
 Example 2:

 Given input matrix =
 [
 [ 5, 1, 9,11],
 [ 2, 4, 8,10],
 [13, 3, 6, 7],
 [15,14,12,16]
 ],

 rotate the input matrix in-place such that it becomes:
 [
 [15,13, 2, 5],
 [14, 3, 4, 1],
 [12, 6, 8, 9],
 [16, 7,10,11]
 ]

 */
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
