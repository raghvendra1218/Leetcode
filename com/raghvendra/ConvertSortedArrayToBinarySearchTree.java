package com.raghvendra;

/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the
two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */

/**
 * Intuition: Since we have to create a height balanced tree, we need to find mid of array and take that root.
 * The idea for finding mid and selecting the parent node for each sub-tree will continue till the size fo array is one and that will the leaf node
 */

public class ConvertSortedArrayToBinarySearchTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        //check the boundary condition
        if(nums == null || nums.length == 0) return null;

        //Call the recursive function and get the work done
        return constructBST(nums, 0, nums.length - 1);
    }

    private TreeNode constructBST(int[] nums, int start, int end){
        //Base case, basically they will be the leaf nodes
        if(start > end) {
            return null;
        }
        int mid = start + (end - start)/2;
        TreeNode current = new TreeNode(nums[mid]);
        current.left = constructBST(nums, start, mid  - 1);
        current.right = constructBST(nums, mid + 1, end);
        return current;
    }
}
