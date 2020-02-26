package com.raghvendra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MinimumDepthOfBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public int minDepth(TreeNode root){
        int depth = 1;
        List<Integer> nodeValues = new ArrayList<>();
        if(root == null) return 0;

        LinkedList<TreeNode> current = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();

        current.add(root);

        while(!current.isEmpty()){
            TreeNode node = current.remove();

            if(node.left != null && node.right!=null){
                depth++;
            }
            nodeValues.add(node.val);

            if(current.isEmpty()){
                current = next;
                next = new LinkedList<>();
                nodeValues = new ArrayList<>();
            }
        }
        return depth;
    }
}
