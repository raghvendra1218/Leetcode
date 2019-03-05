package com.raghvendra;

public class MinimumDistanceBetweenBSTNodes {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    private int min = Integer.MAX_VALUE;
    private Integer prevValue = null;
    public int minDiffInBST(TreeNode root) {
       inOrder(root);
       return min;
    }

    private void inOrder(TreeNode root){
        if(root != null ){
            inOrder(root.left);
            if(prevValue != null){
                min = Math.min(min, root.val - prevValue);
            }
            prevValue = root.val;
            inOrder(root.right);
        }
    }
}
