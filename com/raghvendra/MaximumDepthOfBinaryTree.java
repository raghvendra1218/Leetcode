package com.raghvendra;

/*
1. Calculate the depth of Left Side.
2. Calculate the depth of Right side
3. Calculate the max of them
4. return the result
 */


public class MaximumDepthOfBinaryTree {

     private class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return 1 + Math.max(leftHeight,rightHeight);
    }

}
