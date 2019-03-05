package com.raghvendra;

public class LowestCommonAncestorOfBinarySearchTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        TreeNode result;
        result = inOrder(root, p, q);
        return result;
    }

    private TreeNode inOrder(TreeNode root, TreeNode p, TreeNode q){
        if(root != null){
            if(root == p || root == q) return root;
            TreeNode left = inOrder(root.left, p, q);
            TreeNode right = inOrder(root.right,p,q);
            if(left != null && right != null) return root;
            return (left != null) ? left : right;
        }
        return null;
    }
}
