package com.raghvendra;

import java.util.Stack;

public class KthSmallestElementInBST {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    /*
    Inefficient, Unnecessary storing the value in the result ArrayList wastage of both memory and time
    Approach 1: Leveraging BST inOrder traversal and retriving the kth element from the result Array
     */

//    public int kthSmallest(TreeNode root, int k) {
//        List<Integer> result = new ArrayList<>();
//        result = inOrder(root, result);
//        return result.get(k-1);
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
    Approach 2: Leveraging BST inOrder traversal and checking string the root node value once counter hits k during recursion when value of k is reached
    */
//    int result = Integer.MIN_VALUE;
//    int counter = 0;
//    public int kthSmallest(TreeNode root, int k) {
//        inOrder(root,k);
//        return result;
//    }
//
//    private void inOrder(TreeNode root, int k){
//        if(root != null){
//            inOrder(root.left,k);
//            counter++;
//            if(counter == k) result = root.val;
//            inOrder(root.right,k);
//        }
//    }

    /*
    Approach 3: Leveraging BST inOrder traversal through Iterative approach and breaking the loop when value of counter hits k
    */

    int counter = 0;
    int result = Integer.MIN_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return -1;
        TreeNode node = root;

        while (stack.isEmpty() || node != null){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            counter++;
            if(counter == k) return node.val;
            node = node.right;
        }
        return -1;
    }

}
