package com.raghvendra;
/*
A binary tree is univalued if every node in the tree has the same value.

Return true if and only if the given tree is univalued.



Example 1:


Input: [1,1,1,1,1,null,1]
Output: true
Example 2:


Input: [2,2,2,5,2]
Output: false


Note:

The number of nodes in the given tree will be in the range [1, 100].
Each node's value will be an integer in the range [0, 99].
 */


public class UnivaluedBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public boolean isUnivalTree(TreeNode root) {
        //Check for leaf nodes also count as Unival tree
        if(root == null) return true;
        //Check for if the left node exists, then if it's value is not equal to the root's node val then it is not a unival tree
        if(root.left != null && root.left.val != root.val) return false;
        //Check for if the right node exists, then if it's value is not equal to the root's node val then it is not a unival tree
        if(root.right != null && root.right.val != root.val) return false;
        //Finally we need to check the root on which we are, the left sub-tree and the right sub-tree must be unival for the entire tree tree to be unival
        if(isUnivalTree(root.left) && isUnivalTree(root.right)) return true;
        return false;
    }
}
