package com.raghvendra;

import java.util.Stack;

public class ValidateBinarySearchTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        //Create a Stack for storing node Values
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode node  = root;
//        double temp = -Double.MAX_VALUE;
//
//        while(true){
//            if(node!=null){
//                stack.push(node);
//                node = node.left;
//            } else {
//                if(stack.isEmpty()) break;
//                node = stack.pop();
//                if(node.val > temp){
//                    temp = node.val;
//                } else {
//                    return false;
//                }
//                node = node.right;
//            }
//        }
//        return true;
//    }

        //Create a Stack for storing node Values
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        double temp = -Double.MAX_VALUE;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.val <= temp) return false;
            temp = node.val;
            node = node.right;
        }
        return true;
    }
}
