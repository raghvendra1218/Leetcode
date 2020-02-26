package com.raghvendra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    private class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            val = x;
        }
    }

    public List<List<Integer>>zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> nodeValues = new ArrayList<>();

        //check if the root is null
        if(root == null) return result;

        //Create two Linked Lists to store the current and next values in each level
        LinkedList<TreeNode> current = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();

        //initialise a counter to keep track of odd and even levels
        int level = 0;

        //Store the root node in the current to start the process
        current.add(root);

        //Loop through the Tree Until current list is empty
        while(!current.isEmpty()){
            TreeNode node = current.remove();

            //Check if the node has left and right child, if present add them in the next list
            if(node.left != null){
                next.add(node.left);
            }
            if(node.right != null){
                next.add(node.right);
            }

            //Add the node val to node Values
            nodeValues.add(node.val);

            //Check if the current list is empty, if empty put the next list values to the current list, add the nodeValues to the result list
            //and initialize both next and nodeValues Lists
            if(current.isEmpty()){
                current = next;
                next = new LinkedList<>();
                if(level % 2 == 0){
                    result.add(nodeValues);
                } else {
                    List<Integer> temp  = new ArrayList<>();
                    for(int i = nodeValues.size()-1; i>=0; --i){
                        temp.add(nodeValues.get(i));
                    }
                    result.add(temp);
                }

                //increment the level counter after each sucessful addition of the level in the result list
                level++;
                nodeValues = new ArrayList<>();
            }
        }
        return result;
    }
}
