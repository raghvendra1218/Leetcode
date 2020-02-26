package com.raghvendra;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/*
Time Complexity : O(n)
Space Complexity : O(height of the stack), in Worst case height of the stack will be height of the Binary Tree
 */

public class BinaryTreePreorderTraversal {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    /*
    Approach 1 - PreOrder Traversal Using recursion
     */

//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        result = preOrder(root,result);
//        return result;
//    }
//
//    private List<Integer> preOrder(TreeNode root, List<Integer> result){
//        if(root != null){
//            result.add(root.val);
//            preOrder(root.left,result);
//            preOrder(root.right,result);
//        }
//        return result;
//    }

    /*
    Approach 2 - Iterative Solution
     */

    public List<Integer> preorderTraversal(TreeNode root) {
        //Create a List for storing the result
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        //If root is not null, let's create the Stack to store the values of tree
        Stack<TreeNode> stack = new Stack<>();

        //Add the root node to the stack, to begin the process
        stack.push(root);

        //Repeat the process until the stack is empty
        while(!stack.isEmpty()){
            //remove the element from the top of stack
            TreeNode node = stack.pop();

            //Add the value of the popped node to the result List
            result.add(node.val);

            //Check the right and left child (in order) if they are present or not, if present push them into the stack
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return result;
    }
}
