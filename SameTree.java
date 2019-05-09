package com.raghvendra;
/*
Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
 */

import java.util.Stack;

public class SameTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    /**
     *Approach 1: Recursive Solution, for each node we can check if it's left sub tree is equal to the right subtree
     */
/*    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        if(p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }*/

    /**
     *Approach 2: Iterative Solution, We can do a pre-order traversal for both the trees and check the node value at each nodes
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return  true;
        if(p == null || q == null) return false;
        Stack<TreeNode> treeStackP = new Stack<>();
        Stack<TreeNode> treeStackQ = new Stack<>();
        treeStackP.push(p);
        treeStackQ.push(q);

        while (!treeStackP.isEmpty() && !treeStackQ.isEmpty()){
            TreeNode tempP;
            TreeNode tempQ;
            tempP = treeStackP.pop();
            tempQ = treeStackQ.pop();

            //Check the values of the node if different return false, else check their left and right child
            if(tempP.val != tempQ.val) return false;

            //Check Nodes right children
            if(tempP.right != null && tempQ.right != null){
                treeStackP.push(tempP.right);
                treeStackQ.push(tempQ.right);
            } else if(tempP.right == null && tempQ.right == null){

            } else {
                return false;
            }

            //Check Nodes left children
            if(tempP.left != null && tempQ.left != null){
                treeStackP.push(tempP.left);
                treeStackQ.push(tempQ.left);
            } else if(tempP.left == null && tempQ.left == null){

            } else {
                return false;
            }
        }
        //Both the stacks should be empty after the traversal of the Tree, if not return false
        if(!treeStackP.isEmpty() || !treeStackQ.isEmpty()) return false;
        //else return true
        return true;
    }
}
