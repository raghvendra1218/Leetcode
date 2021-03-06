package com.raghvendra;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 *
 * Example 1:
 *
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: 1
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    private class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((x,y) -> x-y);

        //Add the first meeting end tie to the min heap
        heap.add(intervals[0].end);

        //iterate over the remaining meeting time slots and check if the room is free or not
        //poll the item from the heap if the room is available and add new slot(end time) in heap, else just add new time in the heap
        //number of elements in the heap will give you the minimum number of rooms
        for(int i =1; i< intervals.length; ++i){
            if(heap.peek() < intervals[i].start){
                heap.poll();
                heap.add(intervals[i].end);
            } else {
                heap.add(intervals[i].end);
            }
        }
        return heap.size();
    }
}
