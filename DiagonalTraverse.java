//package com.raghvendra;
//
//public class DiagonalTraverse {
//    public int[] findDiagonalOrder (int[][] matrix) {
//        boolean upDirection = false;
//        boolean downDirection = true;
//        //Initialising the array with length of m*n matrix
//        int [] resultantArr = new int[matrix.length * matrix[0].length];
//        //Traversing the matrix diagonally
//        for(int row = 0;  row < matrix.length; row++) {
//            for(int col = 0; col < matrix[row].length; col++) {
//                if(row == 0 && col == 0){
//                    resultantArr[row] = matrix[row][col];
//                } else if(upDirection && col < matrix[row].length && row > 0) {
//                    row = row - 1;
//                    col = col + 1;
//                } else if(downDirection && row < matrix.length && col > 0) {
//                    row = row + 1;
//                    col = col - 1;
//                }
//                upDirection = true;
//                downDirection = false;
//            }
//        }
//    }
//}
