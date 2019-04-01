package com.raghvendra;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    /**
     * Approach 1: using Brute Force
     * Time Complexity : O(n * k) , k is the size of window
     * Space Complexity : O(1)
     * @param nums
     * @param k
     * @return
     */
/*    int max = Integer.MIN_VALUE;
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return nums;
        int[] result = new int[nums.length - k + 1];
        for(int idx = 0; idx < nums.length; ++idx){
            if(idx + 1 >= k){
                max = findMax(nums, idx + 1 - k, idx);
                result[idx + 1 - k] = max;
            }
        }
        return result;
    }

    private int findMax(int[] nums, int start, int end){
        int maxWindowElement = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++){
            maxWindowElement = Math.max(maxWindowElement, nums[i]);
        }
        return maxWindowElement;
    }*/

    /**
     * Approach 2 : Using Deque
     * Intuition: Deque will always contain the first element as max element , we will pop_back the element if the new element in consideration
     * is larger than the stored element in deque.
     * Time Complexity : O(n)
     * Space Complexity : O(k), k: is the size of window
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return nums;
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];

        for(int idx = 0; idx < nums.length; ++idx){
            //check if the element from deque needs to be popped, which is checking if the k size window has new elements
            if(!deque.isEmpty() && deque.peekFirst() == idx - k){
                deque.pollFirst();
            }

            //pop the elements from the back of the deque if new element is greater than stored elements in the deque, this will ensure
            //the max element at the top of queue
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[idx]){
                deque.pollLast();
            }

            //add the element's index in deque
            deque.offer(idx);

            if(idx + 1 >= k){
                result[idx + 1 - k] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
