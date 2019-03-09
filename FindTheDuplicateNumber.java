package com.raghvendra;

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
