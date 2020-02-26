package com.raghvendra;

public class TrappingRainWater {

    /**
     * Intuition: We will calculate the amount of water which can be collected on each tower and sum the total units to get the answer
     * @param height
     * @return maximum area trapped in water
     */
    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int left = 0;
        int right  = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int trapperWater = 0;

        //traverse through the entire height array and calculate the amount of water stored on each tower
        //Here we will take store the leftMax and rightMax and calculate the amount of water on each tower
        while (left <= right){
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                } else {
//                    trapperWater += Math.min(leftMax, rightMax) - height[left];
                    trapperWater += leftMax - height[left];
                }
            left++;
            } else {
                if(height[right] >= rightMax){
                    rightMax = height[right];
                } else {
//                    trapperWater += Math.min(leftMax,rightMax) - height[right];
                    trapperWater += rightMax - height[right];
                }
                right --;
            }
        }
        return trapperWater;
    }
}
