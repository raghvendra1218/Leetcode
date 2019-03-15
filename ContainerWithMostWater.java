package com.raghvendra;

/**
 * Intiuition : Take two pointers from low and high and calculate the area with the lowest bar , update the maxArea by comparing the
 * current area and the maxArea, progress from that side which has low value
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int area = 0;
        int low = 0;
        int high = height.length - 1;
        while(low < high){
            int minIndexValue = Math.min(height[low], height[high]);
            area = minIndexValue * (high - low);
            maxArea = Math.max(area, maxArea);
            if(height[low] == minIndexValue){
                low++;
            } else {
                high--;
            }
        }
        return maxArea;
    }
}
