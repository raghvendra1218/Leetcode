package com.raghvendra;

public class MedianOftwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int nums1Length = nums1.length;
//        int nums2Length = nums2.length;
//        int PartitionX, PartitionY;
//        int low = 0;
//        int high = (nums1Length < nums2Length) ? nums1Length : nums2Length;
//        int leftMaxX, rightMinX, leftMaxY, rightMinY;
//
//        while(low <= high){
//            if(nums1Length < nums2Length){
//                PartitionX = (low + high)/2;
//                PartitionY = (nums1Length + nums2Length +1)/2 - PartitionX;
//                leftMaxX = (PartitionX == 0) ? Integer.MIN_VALUE : nums1[PartitionX -1];
//                rightMinX = (PartitionX == high) ? Integer.MAX_VALUE : nums1[PartitionX];
//
//                leftMaxY = (PartitionY == 0) ? Integer.MAX_VALUE : nums2[PartitionY -1];
//                rightMinY = (PartitionY == nums2Length) ? Integer.MAX_VALUE : nums2[PartitionY];
//
//            } else {
//                PartitionY = (low + high)/2;
//                PartitionX = (nums1Length+nums2Length +1)/2 - PartitionY;
//                leftMaxX = (PartitionY == 0) ? Integer.MIN_VALUE : nums2[PartitionY -1];
//                rightMinX = (PartitionY == high) ? Integer.MAX_VALUE : nums2[PartitionY];
//
//                leftMaxY = (PartitionX == 0) ? Integer.MAX_VALUE : nums1[PartitionX -1];
//                rightMinY = (PartitionX == nums1Length) ? Integer.MAX_VALUE : nums1[PartitionX];
//            }
//            if(leftMaxX <= rightMinY && leftMaxY <= rightMinX){
//                if((nums1Length + nums2Length) %2 == 0)
//                    return (double) (Math.max(leftMaxX,leftMaxY) + Math.max(rightMinX,rightMinY))/2;
//            } else if(leftMaxX > rightMinY) high = PartitionX - 1;
//            else low = PartitionX + 1;
//        }
//        return -1.0;

        /**
         * Clean Approach
         */
        //If nums1 length is greater than nums2 length, then switch the parameter to make sure that nums1 is always smaller than nums2
        if(nums1.length > nums2.length){
            findMedianSortedArrays(nums2,nums1);
        }

        int x = nums1.length;
        int y = nums2.length;
        int low = 0;
        int high = x;

        while(low <= high){
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            int leftMaxX = (partitionX == 0)? Integer.MIN_VALUE : nums1[partitionX - 1];
            int rightMinX = (partitionX == x)? Integer.MAX_VALUE : nums1[partitionX];

            int leftMaxY = (partitionY == 0)? Integer.MIN_VALUE : nums2[partitionY - 1];
            int rightMinY = (partitionY == y)? Integer.MAX_VALUE : nums2[partitionY];

            if(leftMaxX <= rightMinY && leftMaxY <= rightMinX){
                if((x + y) % 2 == 0) return (double)(Math.max(leftMaxX, leftMaxY) + Math.min(rightMinX,rightMinY))/2;
                else return (double) (Math.max(leftMaxX,leftMaxY));
            }
            else if(leftMaxX > rightMinY){ //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }
        throw new IllegalArgumentException();
    }
}
