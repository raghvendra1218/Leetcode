package com.raghvendra;

/*

Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?
 */

import java.util.ArrayList;
import java.util.List;

/**
 * When generating each row, we can use the previous row directly, so this way we only use O(k) space with k being the number of row.
 * For each new row, we append a 1, letting j iterate from i - 1 backward to 1,
 * and set the jth element as res.set(j, res.get(j-1) + res.get(j)). For example, when k = 4, the process goes like this:
 * k == 0
 * [1]
 * k == 1
 * [11]
 * k == 2
 * [111]  add 1
 * [121]  calculate jth spot
 * k == 3
 * [1211]  add 1
 * [1331]   calculate jth spot
 * k == 4
 * [13311]  add 1
 * [14641]  calculate jth spot
 */

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i <= rowIndex; ++i){
            result.add(1);
            for(int j = i - 1; j > 0; --j){
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }
        return result;
    }
}
