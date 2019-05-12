package com.raghvendra;
/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Example:

BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false


Note:

next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.

 */

import java.util.Stack;

public class BinarySearchTreeIterator {
    private Stack<TreeNode> myStack;
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public BinarySearchTreeIterator(TreeNode root) {
        myStack = new Stack<>();
        pushAll(root);
    }

    public void pushAll(TreeNode root){
        while(root != null){
            this.myStack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode temp = myStack.pop();
//        temp = temp.right;
//        while(temp.right != null){
//            this.myStack.push(temp);
//            temp = temp.left;
//        }
        pushAll(temp.right);
        return temp.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !myStack.isEmpty();
    }
}
