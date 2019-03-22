package com.raghvendra;

public class JumpGame {

    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int len = nums.length;

        //To store the max distance one can reach to from the index
        int maxDistanceReach = 0;
        for (int i = 0; i < len; ++i){
            //if current index is greater than the maxDistanceReach then one cannot reach the last index
            //if maxDistance is greater than lastIndex then it's safe to break and say that one can reach to last index, no need to check further
            if(i > maxDistanceReach || maxDistanceReach >= len - 1){
                break;
            }

            //update the maxDistanceReach in each Iteration by the comparing the previous hops to the current hops on that index.
            maxDistanceReach = Math.max(maxDistanceReach, i + nums[i]);
        }

        return maxDistanceReach >= len - 1;  // it means that it return true if maxDistanceReach >= len - 1
    }
}
