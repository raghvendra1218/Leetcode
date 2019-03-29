package com.raghvendra;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * Intuition : Traverse to the left most node
 *             Store the right node in temp and assign the left node to the right of the current root
 *             mark the current root-> right with one pointer, because subtree in the right may also contain left node, hence we require a node which can keep track for the root->right
 *             At last traverse the right sub-tree, recursively
 */

public class FlattenBinaryTreeToLinkedList {
    private class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int x){
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        //Base case for recursion
        if(root == null || (root.left == null && root.right == null)) return;
        if(root.left != null){
            flatten(root.left);
            TreeNode temp = root.right;
            root.right = root.left;
            //making the left of root to null
            root.left = null;
            TreeNode it = root.right;
            while (it.right != null){
                it = it.right;
            }
            it.right = temp;
        }
        /** flatten the right side of tree */
        flatten(root.right);
    }
}
