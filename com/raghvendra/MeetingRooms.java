package com.raghvendra;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 *
 * Example 1:
 *
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: true
 */


import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    public class Interval {
     int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

//    private class IntervalComparator implements Comparator<Interval>{
//        @Override
//        public int compare(Interval o1, Interval o2) {
//            return Integer.compare(o1.start,o2.start);
//        }
//    }
//    public boolean canAttendMeetings(Interval[] intervals) {
//        List<Interval> intervals1 = new ArrayList<>();
//        for(Interval i : intervals){
//            intervals1.add(i);
//        }
//        Collections.sort(intervals1, new IntervalComparator());
//        for(int i = 1; i<intervals1.size()-1; ++i){
//            if(intervals1.get(i-1).end > intervals1.get(i).start){
//                return false;
//            }
//        }
//        return true;
//    }

    /** Approach 2: Saving additional Space which has been allocated to create extra ArrayList */
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        for(int i =1; i <intervals.length; ++i){
            if(intervals[i-1].end < intervals[i].start) return false;
        }
        return true;
    }
}
