package com.raghvendra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindBottomLeftTreeValue {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        int result = 0;
        List<Integer> nodeValues = new ArrayList<>();

        if(root == null) return result;

        //Store the current and next level Treenode values in the two Linked Lists
        LinkedList<TreeNode> current = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();

        //Add the root element in the current list to begin the process
        current.add(root);

        //Traverse the tree level by level using the above two Lists
        while(!current.isEmpty()){
            TreeNode node = current.remove();

            if(node.left != null){
                next.add(node.left);
            }
            if(node.right != null){
                next.add(node.right);
            }

            //Add the node value in nodeValues list (required only when the next list is empty, as we are concerned only for the last level)
            if(next.isEmpty()){
                nodeValues.add(node.val);
            }

            //check if the current list is empty, if yes, then assign the next list values to the current List
            //and initialise the next and the nodeValues list.
            if(current.isEmpty()){
                current = next;
                next = new LinkedList<>();
                if(!current.isEmpty()){
                    nodeValues = new LinkedList<>();
                } else {
                    result = nodeValues.get(0);
                }
            }
        }
        return result;
    }
}
