package com.raghvendra;

public class InorderSuccessorInBST {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        /**
         * Case 1: if the root mentioned has a right child , then traverse in the right to extreme left which will be the answer
         */
        if (p.right != null) {
            TreeNode node = p.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        /**
         * Case 2: when the given node does not have right child, then logic is that we can find/search the node in the tree starting from root
         * and while performing the search we can store the value of the last left node which will be our answer, it would be better if you visualise
         * this with a tree.
         */
        TreeNode node = root;
        TreeNode store = null;
        while(node.val != p.val){
            if(p.val < node.val){
                store = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return store;

//        TreeNode node = null;
//        while (root != null) {
//            if (p.val < root.val) {
//                node = root;
//                root = root.left;
//            } else if (p.val > root.val) {
//                root = root.right;
//            } else {
//                break;
//            }
//        }
//        return node;
    }
}
