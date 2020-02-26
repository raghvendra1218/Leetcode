package com.raghvendra;

import java.util.*;


public class MergeIntervals {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {
        Map<Integer,Integer> myMap = new TreeMap<>();
        List<Interval> sortedList = new ArrayList<>();
        for(Interval I : intervals){
            if(myMap.containsKey(I.start)){
                if (((I.end < myMap.get(I.start)))) {
//                    myMap.put(I.start, myMap.get(I.start));
                } else {
                    myMap.put(I.start, I.end);
                }
            } else {
                    myMap.put(I.start,I.end);
                }
            }
        for(Map.Entry<Integer,Integer> entry : myMap.entrySet()){
            Interval temp = new Interval(entry.getKey(),entry.getValue());
            sortedList.add(temp);
        }
        //Merge the List
        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (Interval interval : sortedList) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
//        int i = 0;
//        boolean flag;
//        Iterator<Interval> outerIntervalIterator = sortedList.iterator();
//        Iterator<Interval> innerIntervalIterator = sortedList.iterator();
//        while(outerIntervalIterator.hasNext()){
//            flag = true;
//            outerIntervalIterator.next();
//            resultList.add(sortedList.get(i));
//            while(innerIntervalIterator.hasNext()){
//                if(flag){
//                    innerIntervalIterator.next(); //move the iterator by one position to move to the index = 0 only for first time when inner while starts;
////                    i++;
//                    flag = false;
//                }
//                Interval I = innerIntervalIterator.next(); //move the iterator by oen position to move to the index = 1;
////                i++;
//                if(I.start < resultList.get(i).end){
//                    if(I.end <= resultList.get(i).end){
//                        sortedList.remove(I);
//                    } else {
//                        Interval temp = new Interval(resultList.get(i).start,I.end);
//                        resultList.set(i,temp);
//                    }
//                }
//            }
//            i++;
//        }
//
//        return sortedList;
    }


}
