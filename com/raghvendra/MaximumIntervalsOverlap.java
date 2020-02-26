package com.raghvendra;

/**
 * Consider a big party where a log register for guest’s entry and exit times is maintained.
 * Find the time at which there are maximum guests in the party. Note that entries in register are not in any order.
 * Example :
 *
 * Input: arrl[] = {1, 2, 9, 5, 5}
 *        exit[] = {4, 5, 12, 9, 12}
 * First guest in array arrives at 1 and leaves at 4,
 * second guest arrives at 2 and leaves at 5, and so on.
 *
 * Output: 5
 * There are maximum 3 guests at time 5.
 *
 */

import java.util.Arrays;

/**
 * Approach 1: An Efficient Solution is to use sorting n O(nLogn) time.
 * The idea is to consider all events (all arrivals and exits) in sorted order.
 * Once we have all events in sorted order, we can trace the number of guests at any time keeping track of guests that have arrived,
 * but not exited.
 arr[]  = {1, 2, 10, 5, 5}
 dep[]  = {4, 5, 12, 9, 12}

 Below are all events sorted by time.  Note that in sorting, if two
 events have same time, then arrival is preferred over exit.
 Time     Event Type         Total Number of Guests Present
 ------------------------------------------------------------
 1        Arrival                  1
 2        Arrival                  2
 4        Exit                     1
 5        Arrival                  2
 5        Arrival                  3    // Max Guests
 5        Exit                     2
 9        Exit                     1
 10       Arrival                  2
 12       Exit                     1
 12       Exit                     0
 */

public class MaximumIntervalsOverlap {
    public void findMaxGuest(int arrival[], int[]exit){
        Arrays.sort(arrival);
        Arrays.sort(exit);
        int n = arrival.length;
        int max_guest_count = 1, guest_in = 1, time = arrival[0];
        int i = 1, j = 0;
        // Similar to merge in merge sort to process
        // all events in sorted order
        while(i < n && j < n){
            //If next event in the sorted order is arrival, then we will add the guest_in count
            // Else if the event is exit , reduce the number of count from guest_in
            if(arrival[i] <= exit[j]){
                guest_in++;
                //Update the max_guest_count and time
                if(max_guest_count < guest_in){
                    max_guest_count = guest_in;
                    time = arrival[i];
                }
                i++;
            } else {
                guest_in--;
                j++;
            }
        }
        System.out.println("Maximum number of prople are " + max_guest_count + " present at time " + time);
    }
}
