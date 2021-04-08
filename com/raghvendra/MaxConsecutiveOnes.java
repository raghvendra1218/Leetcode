package com.raghvendra;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int countOnes = 0;
        for (int num : nums) {
            if (num == 1) {
                // count consecutive ones
                countOnes++;

            } else {
                // count the maxOnes,
                // initialize the counter and continue;
                maxOnes = Math.max(countOnes, maxOnes);
                countOnes = 0;
            }
        }

        return Math.max(countOnes, maxOnes);
    }
}
