package com.raghvendra;

public class RangeSumOfBST {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }
    }

    private int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        inorderTraversal(root, low, high);
        return sum;
    }

    private void inorderTraversal(TreeNode root, int low, int high) {
        if(root != null) {
            // Do not travel in the left if the left sub-tree is lesser than low value
            if(root.val >= low) inorderTraversal(root.left, low, high);
            if(root.val >= low && root.val <= high) {
                sum += root.val;
            }
            // Do not travel in the left if the left sub-tree is greater than high value
            if(root.val <= high) inorderTraversal(root.right, low, high);
        }
    }
}
