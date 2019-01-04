package com.raghvendra;

public class PivotIndex {
    public int pivotIndex (int [] nums){
        int index=-1;
        int leftArraySum=0;
        int righArraySum=0;
        int arraySum=0;

        //calculate the sum of the array
        for(int element:nums){
        arraySum+= element;
        }

        for(int i =0 ; i< nums.length; i++) {
            if(i == 0) {
                leftArraySum = 0;
                righArraySum = arraySum - nums[i];
            } else {
                leftArraySum += nums[i - 1];
                righArraySum -= nums[i];
            }
            if(leftArraySum == righArraySum) {
                index  = i;
                return index;
            }
        }
        return index;
    }

}
