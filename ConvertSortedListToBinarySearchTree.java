package com.raghvendra;
/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two
subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        //Check the boundary conditions
        if(head == null) return null;
        List<Integer> myList = new ArrayList<>();
        //calculate the size of the LinkedList
        ListNode curr = head;
        while (curr != null){
            myList.add(curr.val);
            curr = curr.next;
        }
        System.out.println(myList);
        return constructBST(myList,0, myList.size() - 1);
    }

    private TreeNode constructBST(List<Integer> myList, int start, int end){
        //Base case
        if(start > end){
            return null;
        }
        int mid  = start + (end - start)/2;
        TreeNode current  = new TreeNode(myList.get(mid));
        current.left = constructBST(myList, start, mid - 1);
        current.right = constructBST(myList, mid + 1, end);
        return current;
    }

}
