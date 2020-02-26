package com.raghvendra;

/**
    Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

    Example 1:

    Input: [1,3,4,2,2]
    Output: 2
    Example 2:

    Input: [3,1,3,4,2]
    Output: 3
    Note:

    You must not modify the array (assume the array is read only).
    You must use only constant, O(1) extra space.
    Your runtime complexity should be less than O(n2).
    There is only one duplicate number in the array, but it could be repeated more than once.
 */

/**
 * Intuition : Linked List cycle concept, Have two pointers Tortoise and Hare and run them by the value at the index, run the hare
 * twice as tortoise eventually they will meet at the intersection (means index have same values). Then take two pointers one from the
 * start of the array and the second from the position from the hare, now run them with the value at the index one by one, when they will meet
 * that would be the duplicate present in the Array
 */

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare  = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while(hare != tortoise);
        //return tortoise; // cannot do this, because Hare moves twice does not guarantee that it will the duplicate number, could be the case
                         //when Tortoise and Hare meet the same index, but that does not guarantee a dupicate, do a dry run on [3,1,4,4,2]
        int ptr1 = tortoise;
        int ptr2 = nums[0];
        while(ptr1 != ptr2){
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }
}
