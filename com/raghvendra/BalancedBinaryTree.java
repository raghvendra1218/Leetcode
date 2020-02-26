package com.raghvendra;
/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
 */

public class BalancedBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        //Keeping -1 as a measure to check if the tree is balanced or not
        return (depth(root) != -1);
    }

    private int depth(TreeNode root){
        if(root == null) return 0;
        int leftHeight = depth(root.left);
        int rightHeight = depth(root.right);
        if(leftHeight == -1 || rightHeight == -1) return -1;
        if(Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight,rightHeight) + 1;
    }
}
