package com.raghvendra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        List<Integer> nodevalues = new ArrayList<>();

        //Check if the root is null
        if(root == null) return result;

        //Create two Linked Lists to keep the current level and next level elements in the tree
        LinkedList<TreeNode> current = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();

        //Store the root value in the current list to initialise the process
        current.add(root);

        //Loop through the tree until current list is empty
        while(!current.isEmpty()){
            //Storing the value from the current list in a temporary variable of Treenode type
            TreeNode node = current.remove();
            //Check if the node have left or right child
            if(node.left != null){
                next.add(node.left);
            }
            if(node.right != null){
                next.add(node.right);
            }

            //Store the node val in the nodeValues list
            nodevalues.add(node.val);
            //Check if the current list is empty, if yes assign the next values to the current list and add the last element
            //of the result list in the result list
            if(current.isEmpty()){
                current = next;
                next = new LinkedList<>();
                //Adding the last element of the nodeValues in the result list, that;s the right view of the tree
                result.add(nodevalues.get(nodevalues.size()-1));
                nodevalues = new ArrayList<>();
            }
        }
        return result;
    }
}
