package com.raghvendra;

public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        /**
         * Time Complexity : O(nlogn)
         */
        //Sort the Array and then check the maximum 3 digit which can be formed from both the sides
/*       int productFromFirst = 1;
        int productFromLast = 1;
        Arrays.sort(nums);
        productFromFirst = nums[0] * nums[1] * nums[nums.length -1];
        productFromLast = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        return (productFromFirst > productFromLast) ? productFromFirst : productFromLast;
        }*/

        /**
         * Approach 2: Single Scan, As per the above intuition, we need to find two minimum values and three maximum values
         * instead of sorting entire Array, let's concentrate in finding two minimum values and three maximum values
         */
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for (int n : nums) {
            if (n <= min1) {
                min2 = min1;  //This line ensures that min2 is always greater than or equal to min1, idea is that if we get most lowest value we assign it to min1, and the previous value of min1 is assigned to min2
                min1 = n;
            } else if (n <= min2) {
                min2 = n;
            }
            if (n >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {
                max3 = n;
            }
        }
        return Math.max((min1*min2*max1),(max1*max2*max3));


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
