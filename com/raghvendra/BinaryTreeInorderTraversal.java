package com.raghvendra;

/*
Time Complexity : O(n)
Space Complexity : O(height of the stack), in Worst case height of the stack will be height of the Binary Tree
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    /*
    Approach 1: Recursive Solution
     */
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        result = inOrder(root, result);
//        return result;
//    }
//
//    private List<Integer> inOrder(TreeNode root, List<Integer> result){
//        if(root != null){
//            inOrder(root.left,result);
//            result.add(root.val);
//            inOrder(root.right,result);
//        }
//        return result;
//    }

    /*
    Approach 2 - Iterative Solution
     */

/*    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result =  new ArrayList<>();
        if(root == null) return result;

        Stack<TreeNode> stack = new Stack<>();

        //Using a Temp variable to traverse through the tree, however not required we can travel by root as well
        TreeNode node  =  root;

        //Traversing through the tree until Stack is empty OR node is equal to null
        while(true){
            if(node != null){
                stack.push(node);
                node = node.left;
            } else {
              if(stack.isEmpty()) break;
              node = stack.pop();
              result.add(node.val);
              node = node.right;
            }
        }
        return result;
    }*/

    public List < Integer > inorderTraversal(TreeNode root) {
        List< Integer > res = new ArrayList< >();
        Stack< TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}
