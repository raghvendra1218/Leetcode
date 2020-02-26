package com.raghvendra;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        int result  = Integer.MIN_VALUE;
        //Create priority queue with least element on the top
        PriorityQueue<Integer> myHeap = new PriorityQueue<>((x, y) -> x-y);
        //Pop the elements from the priority queue as soon as the size of queue exceeds k
        for (int i : nums){
            myHeap.add(i);
            if(myHeap.size() > k) {
                myHeap.poll();
            }
        }
        result = myHeap.peek();
        return result;
    }
}
