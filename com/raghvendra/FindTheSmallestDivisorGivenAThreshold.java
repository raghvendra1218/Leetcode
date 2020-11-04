package com.raghvendra;

public class FindTheSmallestDivisorGivenAThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int start  = 1;
        int end = nums[nums.length - 1];
        int mid, sum;

        while(start <= end) {
            mid = start + (end - start)/2;
            sum = checkSum(mid, nums);
            if(sum > threshold){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    private int checkSum(int mid, int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n / mid + (n % mid == 0 ? 0 : 1);
        }
        return sum;
    }
}
