package com.raghvendra;
/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3


But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3


Note:
Bonus points if you could solve it both recursively and iteratively.
 */

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        //Check the edge cases
        if(root == null) return true;

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right){
        //check the base cases
//        if(left == null || right == null){
//            if(left == right) return true;
//            return false;
//        }
//        OR
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        //check if the values of the nodes are equal or not
        if(left.val != right.val) return false;
        //check if the left and right node's left subtree are symmetric or not
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    /**
     * Approach 2: Iterative Solution
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        //Store the value in quue, Since tree will be symmetric we just need to check the left and righ nodes are exactly equal,
        //be careful while inserting the left and right child of nodes while traversing
        Queue<TreeNode> myqueue = new LinkedList<>();
        //Add the root twice This is done, because we need child of left and right Noes for root
        myqueue.offer(root);
        myqueue.offer(root);

        while (!myqueue.isEmpty()){
            TreeNode t1 = myqueue.poll();
            TreeNode t2 = myqueue.poll();
            if(t1 == null && t2 == null) continue;
            if(t1 == null || t2 == null) return false;
            if(t1.val != t2.val) return false;
            //Add the child for left and right
            //The order must be such that we are checking the mirror image nodes
            myqueue.offer(t1.left);
            myqueue.offer(t2.right);
            myqueue.offer(t1.right);
            myqueue.offer(t2.left);
        }
        return true;
    }
}
