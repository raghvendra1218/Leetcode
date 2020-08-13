package com.raghvendra;

import java.util.Arrays;
import java.util.Collections;

/**
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each,
 * and the other N − h papers have no more than h citations each."
 *
 * Example:
 *
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
 *              received 3, 0, 6, 1, 5 citations respectively.
 *              Since the researcher has 3 papers with at least 3 citations each and the remaining
 *              two with no more than 3 citations each, her h-index is 3.
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 */

public class H_Index {
    public int hIndex(int[] citations) {
//        //Sort the array
////        if (citations == null || citations.length == 0) return 0;
////        Integer[] citationsObj = Arrays.stream (citations).boxed().toArray(Integer[]::new);
////        Arrays.sort(citationsObj, Collections.reverseOrder());
////        for(int idx = 0; idx < citations.length; ++idx) {
////            if(citations[idx] < idx + 1) {
////                return idx;
////            }
////        }
////        //This case occurs when all the values on the index is greater then the respective index values
////        return citations.length;

        //Second approach, saving time complexity and space complexity
        Arrays.sort(citations);
        int n = citations.length;
        int i;
        for(i=1; i<=n; i++){
            if(citations[n-i] < i)
                break;
        }
        return i-1;
    }
}
