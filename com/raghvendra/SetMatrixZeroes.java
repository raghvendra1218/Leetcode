package com.raghvendra;

public class SetMatrixZeroes {

    /**
     * Approach 1: we can take a separate matrix of m * n size and initialise all the menets to FALSE
     * and while traversing the original matrix set the elements in auxiliary matrix to true where zero occurs
     * At last traverse through the Auxiliary matrix and set the elements(rows/cols) in the original matrix to 0
     * Space Complexity : O(m *n)
     */
    /**
     * Approach 2: instead of taking entire Auxiliary matrix of m * n space we can take two Arrays of size m and n
     * each element in the array denotes corresponding rows and cols becoz we are interested in knowing which row and which col have zero
     * elements becoz entire row and col will be made to zero, hence we will save some space here
     * Space Complexity : O(m + n)
     */
    /**
     * Approach 3: We can solve this Question in_place, instead of taking two arrays of rows and cols we can use the first row and firs col
     * for tracking the number of zeros in the matrix for each row and cols
     * we will take two variables rowZero and colZero to keep track of whether zeroth row and col needs to be set as 0 or not
     */
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        boolean rowZero = false;
        boolean colZero = false;

        //iterate through first row to check if there are any zero values or not
        for(int r : matrix[0]){
            if(r == 0) rowZero = true;
        }

        //iterate through first col to check if there are any zero values or not
//        for(int[] c : matrix){
//            if(c[0] == 0) colZero = true;
//        }
        for(int i = 0; i < matrix.length; ++i){
            if (matrix[i][0] == 0){
                colZero = true;
            }
        }
        //iterate through the rest of matrix basically sta  rt from row 1 and col 1
        for(int row = 1; row < matrix.length; ++row){
            for(int col = 1; col< matrix[0].length; ++col){
                if(matrix[row][col] == 0){
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        //iterate through zeroth col and set the elements in the rest of matrix rows and cols
        for(int row = 1; row < matrix.length; ++row){
            if(matrix[row][0] == 0){
                //iterate through all the elements in that row and set them zero
                for(int col = 1; col < matrix[row].length; ++ col){
                    matrix[row][col] = 0;
                }
            }
        }

        //iterate through the zeroth row and set the elements in the rest of the matrix rows and cols
        for(int col = 1; col < matrix[0].length; ++col){
            if(matrix[0][col] == 0){
                for(int row = 1 ; row < matrix.length; ++row){
                    matrix[row][col] = 0;
                }
            }
        }

        //Now check if the variables rowZero are set or not if set then set all the elements in the zeroth row to be zero
        if(rowZero){
            for(int col = 0; col < matrix[0].length; ++col){
                matrix[0][col] = 0;
            }
        }

        //Now check if the variables colZero are set or not if set then set all the elements in the zeroth row to be zero
        if(colZero){
            for(int row = 0; row < matrix.length; row++){
                matrix[row][0] = 0;
            }
        }
    }
}
