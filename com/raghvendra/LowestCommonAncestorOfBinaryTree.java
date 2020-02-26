package com.raghvendra;

public class LowestCommonAncestorOfBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if(root == null) return null;
        TreeNode result;
        result = traverse(root, p ,q);
        return result;
    }

    private TreeNode traverse(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = traverse(root.left, p, q);
        TreeNode right = traverse(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}
