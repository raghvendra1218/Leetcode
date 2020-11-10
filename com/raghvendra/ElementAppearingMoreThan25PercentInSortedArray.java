package com.raghvendra;

public class ElementAppearingMoreThan25PercentInSortedArray {
    public int findSpecialInteger(int[] arr) {
        int max25PercentLimitCount = arr.length/4 + 1;

        int prevNum = arr[0];
        int counter = 0;
        for(int i = 0; i < arr.length; ++i) {
            if(arr[i] == prevNum){
                counter++;
                if(counter >= max25PercentLimitCount) return arr[i];
            } else {
                prevNum = arr[i];
                counter = 1;
            }
        }

        return -1;
    }

    // Approach 2: Optimized
    public int findSpecialIntegerII(int[] arr) {
        int n = arr.length, t = n / 4;

        for (int i = 0; i < n - t; i++) {
            // check at the i = 0 and i + n/4 index which ensures that this element is has occurred, exactly or more than 25 percent
            // since array is sorted the elements in between will be same.
            if (arr[i] == arr[i + t]) {
                return arr[i];
            }
        }
        return -1;
    }
}
