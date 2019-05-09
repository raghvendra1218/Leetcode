package com.raghvendra;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        /**
         * Time Complexity : O(nlogn)
         */
        //Sort the Array and then check the maximum 3 digit which can be formed from both the sides
        int productFromFirst = 1;
        int productFromLast = 1;
        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        productFromFirst = nums[0] * nums[1] * nums[nums.length -1];
        productFromLast = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        return (productFromFirst > productFromLast) ? productFromFirst : productFromLast;

        /**
         * Approach 2: Time Complexity : O(n)
         */

/*        int maxProduct = 1;
        int localProduct = 1;
        for(int i = 0; i < 3; ++i){
            localProduct *= nums[i];
        }
         maxProduct = localProduct;
        if(nums.length > 3){
            for(int i = 3; i < nums.length; ++i){
                localProduct /= nums[i-3];
                localProduct *= nums[i];
                if(localProduct > maxProduct){
                    maxProduct = localProduct;
                }
            }
        }
        return maxProduct;*/
    }
}
