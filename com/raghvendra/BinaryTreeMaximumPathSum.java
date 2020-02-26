package com.raghvendra;

/*
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along
the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
 */

/**
 * Intuition :  Calculate the Max sum of each branch and keep the track of the maxSum including root node of the subTree (becoz, that's
 * the result, ultimately, we will return). But keep in mind we will not return the result in each call to calculate the path sum.
 */
public class BinaryTreeMaximumPathSum {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    private int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        findMax(root);
        return result;
    }

    private int findMax(TreeNode root){
        //Base condition
        if(root == null){
            return 0;
        }

        int leftSum = findMax(root.left);
        int rightSum = findMax(root.right);
        int maxLeftRight = Math.max(leftSum, rightSum);
        int maxSingle = Math.max(maxLeftRight + root.val , root.val);
        int maxAll = Math.max(maxSingle, (leftSum + rightSum + root.val));
        result = Math.max(maxAll, result);
        return maxSingle;
    }
}
