package com.raghvendra;

public class ClosestBinarySearchTreeValue {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }
    }

    private double minm = Double.MAX_VALUE;
    private int closestValue;
    public int closestValue(TreeNode root, double target) {
        if (root == null) return 0;
        inOrderTraversal(root, target);
        return closestValue;
    }

    private void inOrderTraversal(TreeNode root, double target){
        if(root != null) {
            if((int)target < root.val) inOrderTraversal(root.left, target);
            if(Math.abs(root.val - target) < minm) {
                minm = Math.abs(root.val - target);
                closestValue = root.val;
            }
            inOrderTraversal(root.right, target);
        }
    }
}
