package com.raghvendra;

import java.util.ArrayList;
import java.util.List;

/*
Median is the middle value in an ordered integer list. If the size of the list is even,
there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.


Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2


Follow up:

If all integer numbers from the stream are between 0 and 100, how would you optimize it?
If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */

/**
 * Approach 1: Using twisted Binary Search version
 * Forming an Array List and adding the elements in sorted fashion
 */
public class FindMedianFromDataStream {

    private List<Integer> myList;
    /** initialize your data structure here. */
    public FindMedianFromDataStream() {
        this.myList = new ArrayList<>();
    }

    public void addNum(int num) {
        if(myList.size() == 0){
            myList.add(num);
        } else {
            int idx = findIndex(myList, num);
            myList.add(idx, num);
        }
    }

    public double findMedian() {
        int midIdx = myList.size()/2;
        if(myList.size() % 2 == 0){
            return (myList.get(midIdx - 1) + myList.get(midIdx))/2.0;
        }
        return myList.get(midIdx);
    }

    private int findIndex(List<Integer> myList, int num){
        int start = 0;
        int end  = myList.size() - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(myList.get(mid) == num){
                return mid + 1;
            } else {
                if(myList.get(mid) > num){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return start;
    }
}
