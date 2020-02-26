package com.raghvendra;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Time Complexity : O(n)
Space Complexity : O(height of the stack), in Worst case height of the stack will be height of the Binary Tree
*/

public class BinaryTreePostorderTraversal {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    /*
    Approach 1: Recursive solution
    */

//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        result = postOrder(root,result);
//        return result;
//    }
//
//    private List<Integer> postOrder(TreeNode root, List<Integer>result){
//        if(root != null){
//            postOrder(root.left,result);
//            postOrder(root.right,result);
//            result.add(root.val);
//        }
//        return result;
//    }

    /*
    Approach 2: Recursive solution
    */

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //Check if the toot is null, then return result;
        if(root == null) return result;

        //Create a Stack for storage while traversing the tree
        Stack<TreeNode> stack = new Stack<>();

        //Create a current node and store root in it.
        TreeNode current = root;

        //Traverse the tree till current is null or Stack becomes empty
        while(current !=null || !stack.isEmpty()){
            //Reach till the far left until the current node becomes null and keep adding the entries to stack
            if(current != null){
                stack.push(current);
                current = current.left;
            } else {
                //we are in else means current is null, now;
                //Peek in stack, to check if the element at the top has any right child in tree
                TreeNode temp = stack.peek().right;
                //if there is no right child means temp is null, it implies it's (temp) the leaf node and in this case we have traversed both the left
                //and right of tree, because left was already null for the current that's why we are in else clause.
                if(temp == null){
                    temp = stack.pop();
                    result.add(temp.val);
                    //Check if the popped element is the right child of the currently top element of the stack
                    while(!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        result.add(temp.val);
                    }
                } else {
                    current = temp;
                }
            }
        }
        return result;
    }
}
