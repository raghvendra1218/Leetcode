package com.raghvendra;

public class ValidBoomerang {
    public boolean isBoomerang(int[][] points) {
        int x1 = points[0][0];
        int y1 = points[0][1];
        int x2 = points[1][0];
        int y2 = points[1][1];
        int x3 = points[2][0];
        int y3 = points[0][2];

        // check if the slope is equal for three points
        // if slope is equal then, it does not form a boomerang
        return (y3 - y2)*(x2 - x1) != (y2 - y1)*(x3 - x2);

        // Alternative we can find the area of triangle, if it comes out to be zero then it is not a boomerang
        // [1/2][x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2)]
    }
}
