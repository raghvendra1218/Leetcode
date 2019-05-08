package com.raghvendra;

/*
In a list of songs, the i-th song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
Formally, we want the number of indices i < j with (time[i] + time[j]) % 60 == 0.

Example 1:

Input: [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
Example 2:

Input: [60,60,60]
Output: 3
Explanation: All three pairs have a total duration of 120, which is divisible by 60.

Note:

1 <= time.length <= 60000
1 <= time[i] <= 500
 */

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int count  = 0;
        int[] track =  new int[60];

        //Storing the values of the songs in modular form, as we no no song can go beyond limit of 60 when divided by 60
        for(int i = 0; i < time.length; ++i){
            track[time[i] % 60] ++;
        }
        for(int i = 0; i <= 30; ++i){
            if(i ==0 || i == 30){
                count += (track[i] * (track[i] -1))/2;
            } else {
                count += track[i] * track[60 - i];
            }
        }
        return count;
    }
}
