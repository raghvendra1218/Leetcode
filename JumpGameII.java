package com.raghvendra;

public class JumpGameII {

    /**
     * The main idea is based on greedy. Let's say the range of the current jump is [curBegin, curEnd],
     * maxDistanceReach is the farthest point that all points in [curBegin, curEnd] can reach.
     * Once the current point reaches curEnd, then trigger another jump, and set the new curEnd with maxDistanceReach,
     * then keep the above steps, as the following:
     * @param nums
     * @return
     */
/*    public int jump(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;

        //traverse through the nums array keeping the count of maxDistanceReach from that index in a variable
        int maxDistanceReach = 0;
        int currEnd = 0;
        int jumps = 0;

        for(int i = 0; i < len - 1; ++i){
            maxDistanceReach = Math.max(maxDistanceReach, i + nums[i]);
            if(currEnd == i){
                jumps++;
                currEnd = maxDistanceReach;
            }
        }
        return jumps;
    }*/

    /**
     * Using Dynamic Programming : Time limit exceeds
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int[] numJumps =  new int[nums.length];
        int[] jumpIndex = new int[nums.length];
        for(int i = 0 ; i < nums.length; ++i){
            numJumps[i] = Integer.MAX_VALUE;
            jumpIndex[i] = Integer.MAX_VALUE;
        }

        //initialise the zeroth index accordingly
        numJumps[0] = 0;
        jumpIndex[0] = -1;
        for(int i = 1; i < nums.length ; ++i){
            for(int j = 0; j < i ; j++){
                if(j + nums[j] >= i){
//                    numJumps[i] = Math.min(numJumps[j] + 1, numJumps[i]);
                    if(numJumps[j] + 1 < numJumps[i]){
                        numJumps[i] = numJumps[j] + 1;
                        jumpIndex[i] = j;   //we can use this Array to return the path used for jumping
                    }
                }
            }
        }
        //To print out the path or Index which were taken to travel
        System.out.print("Path: " + (jumpIndex.length - 1) + " ,");
        for(int i = 0; i < jumpIndex.length; ++i){
            System.out.print(jumpIndex[i]);
        }
        for(int i = jumpIndex.length - 1; i >=0; --i){
            System.out.print(jumpIndex[i]+" ,");
            i = jumpIndex[i];
        }
        return numJumps[numJumps.length - 1];
    }
}
