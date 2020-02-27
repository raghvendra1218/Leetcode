package com.raghvendra;
/**
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
 *
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
 *
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
 * plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on.
 * Replace the color of all of the aforementioned pixels with the newColor.
 * At the end, return the modified image.
 * Example 1:
 * Input:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation:
 * From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
 * by a path of the same color as the starting pixel are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected
 * to the starting pixel.
 * Note:
 *
 * The length of image and image[0] will be in the range [1, 50].
 * The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
 * The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int sourceColor = image[sr][sc];
        //condition to check if the sourceColor is same as newColor, then we do'nt have to do anything, we can return the image as it is
        if(sourceColor == newColor) return image;
        helper(image, sr, sc, sourceColor, newColor);
        return image;
    }

    //Helper to traverse through the image
    private void helper(int[][] image, int i, int j, int sourceColor, int newColor) {
        //Base conditions -> boundaries of matrix and if the point at which we are in image does not match the color of the source point(i.e. - source color)
        if(i >= image.length || i < 0 || j < 0 || j >= image[0].length || image[i][j] != sourceColor) {
            return;
        }
        //We just need to change the color of this point to new color which we have been asked to convert to
        image[i][j] = newColor;
        //DFS travel
        helper(image, i+1,j, sourceColor, newColor);
        helper(image, i-1,j, sourceColor, newColor);
        helper(image, i,j+1, sourceColor, newColor);
        helper(image, i,j-1, sourceColor, newColor);
    }
}
