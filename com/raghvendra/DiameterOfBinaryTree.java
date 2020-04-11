package com.raghvendra;

public class DiameterOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Approach 1:  Where we are recursively calculating height and Diameter around that, at each node
     *              Time Complexity = O(nlogn) - good case, when tree is balanced, worst case - O(n^2). In General O(n * Height of Tree)
     */
    public int diameterOfBinaryTree(TreeNode root) {
        int diameter = 0;
        if(root == null) return diameter;

        int option_1 = height(root.left) + height(root.right);
        int option_2 = diameterOfBinaryTree(root.left);
        int option_3 = diameterOfBinaryTree(root.right);
        diameter = Math.max(option_1, Math.max(option_2, option_3));
        return diameter;
    }

    //Helper
    private int height(TreeNode root) {
        if(root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);
        return 1 + Math.max(lh, rh);
    }
}
