package com.raghvendra;

/*
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST
such that their sum is equal to the given target.

Example 1:

Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True


Example 2:

Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
 */

import java.util.ArrayList;
import java.util.List;

public class TwoSumIVInputBST {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nodeValues = new ArrayList<>();
        nodeValues = inOrder(root, nodeValues);
        int i = 0, j = nodeValues.size()-1;
//        while(nodeValues.get(i) + nodeValues.get(j) != k){
//            while((nodeValues.get(i) + nodeValues.get(j) < k)){
//                if(i < j) i++;
//                else {
//                    return false;
//                }
//            }
//            while(nodeValues.get(i) + nodeValues.get(j) > k){
//                if(i < j)j--;
//                else {
//                    return false;
//                }
//            }
//        }
//        if(nodeValues.get(i) + nodeValues.get(j) == k && i != j) return true;
//        return false;
        while(i < j){
            int sum = nodeValues.get(i) + nodeValues.get(j);
            if(sum == k) return true;
            if(sum < k) i++;
            else j--;
        }
        return false;
    }

    private List<Integer> inOrder(TreeNode root, List<Integer> nodeValues){
        if(root != null){
            inOrder(root.left,nodeValues);
            nodeValues.add(root.val);
            inOrder(root.right,nodeValues);
        }
        return nodeValues;
    }
}
