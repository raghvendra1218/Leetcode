package com.raghvendra;

public class BestTimeToBuySellStock {
    /*
    Approach 1: Brute Force
     */
//    public int maxProfit(int[] prices) {
//        if(prices.length<1) return 0;
//        int start = 0, end = prices.length-1;
//        int diffPrev = prices[end] - prices[start];
//        for(;start<end;){
//            while (start < end) {
//                int diff = prices[end] - prices[start];
//                if (diff > diffPrev) {
//                    diffPrev = diff;
//                }
//                start++;
//            }
//            start = 0;
//            end--;
//        }
//        if(diffPrev > 0) return diffPrev;
//        return 0;
//    }

    /*
    Approach Second: By maintaining two variables
     */
    public int maxProfit(int[] prices) {
/*        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i <prices.length;i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            } else if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] -minPrice;
            }
        }
        return maxProfit;*/

        /** Another Approach  - fastest among all */
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int profit = 0;
        for(int i = 0; i < prices.length; ++i){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            } else {
                profit = prices[i] - minPrice;
                maxProfit = Math.max(profit, maxProfit);
            }
        }
        return maxProfit;
    }
}
