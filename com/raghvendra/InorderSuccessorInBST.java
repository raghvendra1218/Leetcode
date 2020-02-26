package com.raghvendra;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 *
 * The successor of a node p is the node with the smallest key greater than p.val.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [2,1,3], p = 1
 * Output: 2
 * Explanation: 1's in-order successor node is 2. Note that both p and the return value is of TreeNode type.
 * Example 2:
 *
 *
 * Input: root = [5,3,6,2,4,null,null,1], p = 6
 * Output: null
 * Explanation: There is no in-order successor of the current node, so the answer is null.
 *
 *
 * Note:
 *
 * If the given node has no in-order successor in the tree, return null.
 * It's guaranteed that the values of the tree are unique.
 */
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
