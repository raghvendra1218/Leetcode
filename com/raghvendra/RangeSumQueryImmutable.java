package com.raghvendra;

public class RangeSumQueryImmutable {
    private static long[] cumSum;
    public RangeSumQueryImmutable(int[] nums) {
        cumSum = new long[nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            cumSum[i] += sum;
        }
        for(long n : cumSum) {
            System.out.println(n);
        }
    }

    public int sumRange(int i, int j) {
        if(i == 0) return (int)cumSum[j];
        return (int) (cumSum[j] - cumSum[i - 1]);
    }
}
