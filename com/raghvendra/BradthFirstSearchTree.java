package com.raghvendra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BradthFirstSearchTree {
    public class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> a1 = new ArrayList<>();
        //Create a List of List for storing the Node Values at each level
        List<Integer> nodeValues = new ArrayList<>();

        //Check if the root is null
        if(root == null) return a1;

        //Create current and next Linked List to store the Node values
        LinkedList<TreeNode> current = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        //Add the root element in the current List to begin the process
        current.add(root);

        while(!current.isEmpty()){
            TreeNode node = current.remove();

            if(node.left != null){
                next.add(node.left);
            }
            if(node.right != null){
                next.add(node.right);
            }
            //Add the node value in the List until the current list is empty
            nodeValues.add(node.val);
            //Check if the Current List is empty, if empty then make the current to next and the node values list to a1 and initialise both the next list and node values list
            if(current.isEmpty()){
                current = next;
                next = new LinkedList<>();
                a1.add(nodeValues);
                nodeValues = new ArrayList<>();
            }
        }
        return a1;
    }
}
