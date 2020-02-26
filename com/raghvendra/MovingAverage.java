package com.raghvendra;

public class MovingAverage {

    /** Initialize your data structure here. */
//    private Queue<Integer> myQueue;
//    private int queueSize;
//    public MovingAverage(int size) {
//        myQueue = new LinkedList<>();
//        queueSize = size;
//    }
//
//    public double next(int val) {
//        double sum = 0;
//        myQueue.offer(val);
//        if(myQueue.size() > queueSize){
//            myQueue.poll();
//        }
//        Queue<Integer> buffer = new LinkedList<>();
//        while(!myQueue.isEmpty()){
//            int temp = myQueue.poll();
//            buffer.offer(temp);
//            sum += temp;
//        }
//        while(!buffer.isEmpty()){
//            myQueue.offer(buffer.poll());
//        }
//        return sum/myQueue.size();
//    }

    /** Approach -2 Using one Array */
    /** Initialize your data structure here. */
    private int[] result;
    private int n, insert;
    private double sum;

    public MovingAverage(int size){
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
