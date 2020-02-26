package com.raghvendra;


/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * Example:
 *
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 */

public class MovingAverageFromDataStream {
    /** Initialize your data structure here. */
/*     private Queue<Integer> myQueue;
     private int queueSize;
     public MovingAverage(int size) {
         myQueue = new LinkedList<>();
         queueSize = size;
     }

     public double next(int val) {
         double sum = 0;
         myQueue.offer(val);
         if(myQueue.size() > queueSize){
             myQueue.poll();
         }
         Queue<Integer> buffer = new LinkedList<>();
         while(!myQueue.isEmpty()){
             int temp = myQueue.poll();
             buffer.offer(temp);
             sum += temp;
         }
         while(!buffer.isEmpty()){
             myQueue.offer(buffer.poll());
         }
         return sum/myQueue.size();
     }*/
    /**
     * Approach 2: Using Array , more fast
     */
    private int[] result;
    private int n, insert;
    private double sum;

    public MovingAverageFromDataStream(int size){
        result = new int[size];
    }

    public double next(int val){
        if(n < result.length) n++;
        sum = sum - result[insert];
        sum += val;
        result[insert] = val;
        insert = (insert + 1) % result.length;
        return sum/n;
    }
}
