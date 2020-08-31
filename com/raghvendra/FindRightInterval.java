package com.raghvendra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindRightInterval {
    private class Interval {
        int start;
        int end;
        int index;

        public Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public int[] findRightInterval(int[][] intervals) {
        List<Interval> sortedListOfIntervals = new ArrayList<>();

        // Prepare a sorted list of intervals
        int idx = 0;
        for(int[]e : intervals){
            Interval i = new Interval(e[0], e[1], idx);
            sortedListOfIntervals.add(i);
            idx++;
        }

        sortedListOfIntervals.sort((a, b) -> a.start - b.start);

        // Traverse through sorted list to find the right intervals, when found add the index in the result array, else add -1 for that interval
        // result array will be of size of the intervals/size of the sorted list
        int[]result = new int[intervals.length];
        for(int i = 0; i < intervals.length; ++i) {
            result[i] = binarySearch(sortedListOfIntervals, intervals[i][1]);
        }

        return result;
    }

    // Binary search
    private int binarySearch(List<Interval>sortedListOfIntervals, int x) {
        int n = sortedListOfIntervals.size();
        if(sortedListOfIntervals.get(n - 1).start < x) return -1;

        int l = 0, r = n - 1;
        while(l <= r) {
            int mid = l + (r - l)/2;
            if(sortedListOfIntervals.get(mid).start >= x) r = mid - 1;
            else l = mid + 1;
        }

        return sortedListOfIntervals.get(l).index;
    }
}
