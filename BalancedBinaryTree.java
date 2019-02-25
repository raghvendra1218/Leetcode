package com.raghvendra;

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
        int height = 0;
        height = depth(root);
        System.out.println(height);
        if(height > 1) return false;
        return true;
    }

    private int depth(TreeNode root){
        if(root == null) return 0;
            int leftHeight = depth(root.left);
            int rightHeight = depth(root.right);
        return Math.abs(leftHeight - rightHeight);
    }
}
