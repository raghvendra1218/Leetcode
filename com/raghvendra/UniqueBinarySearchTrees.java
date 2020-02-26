package com.raghvendra;

/*
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 */

/**
 * Intuition: BST(0) = 1 (null node)
 *            BST(1) = 1
 *            BST(2) = 2 => BST(1st element as root) + BST(2nd element as root)
 *                          BST(0) * BST(1)          + BST(1) * BAST(0)
 *            BST(3) = 5 => BST(1st element as root) + BST(2nd element as root) + BST(3rd element as root)
 *                          BST(0) * BST(2)          + BST(1) * BST(1)            + BST(2) * BST(0)
 *
 *            BST(4) =14 => BST(1st element as root) + BST(2nd element as root) + BST(3rd element as root) + BST(4th element as root)
 *                          BST(0) * BST(3)          + BST(1) * BST(2)            + BST(2) * BST(1)        + BST(3) * BST(0)
 *
 *  This number series is called as "Catalan number".
 */

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if(n < 0) return 0;
        int [] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; ++i){
            for(int j = 0; j < i; ++j){
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
