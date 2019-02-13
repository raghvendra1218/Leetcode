package com.raghvendra;

public class BestTimeToBuySellStock {
    /*
    Approach 1: Brute Force
     */
    public int maxProfit(int[] prices) {
        if(prices.length<1) return 0;
        int start = 0, end = prices.length-1;
        int diffPrev = prices[end] - prices[start];
        for(;start<end;){
            while (start < end) {
                int diff = prices[end] - prices[start];
                if (diff > diffPrev) {
                    diffPrev = diff;
                }
                start++;
            }
            start = 0;
            end--;
        }
        if(diffPrev > 0) return diffPrev;
        return 0;
    }

    /*
    Approach Second:
     */

}
