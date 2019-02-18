package com.raghvendra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BoundaryOfBinaryTree {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root){
        List<Integer> result = new ArrayList<>();
        List<Integer> nodeValues = new ArrayList<>();
        Stack<Integer> storage =  new Stack<>();

        if(root == null) return result;

        LinkedList<TreeNode> current = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();

        current.add(root);

        while(!current.isEmpty()){
            TreeNode node = current.remove();

            if(node.left != null){
                next.add(node.left);
            }
            if(node.right !=null){
                next.add(node.right);
            }

            nodeValues.add(node.val);

            if(current.isEmpty()){
                current = next;
                next = new LinkedList<>();
                if(!current.isEmpty()){
                    result.add(nodeValues.get(0));
                    if(nodeValues.size() !=1) storage.push(nodeValues.get(nodeValues.size()-1));
                } else {
                    for(Integer a : nodeValues) result.add(a);
                }
                nodeValues = new ArrayList<>();
            }
        }
        while((storage.size()> 0) && storage.isEmpty()) result.add(storage.pop());
        return result;
    }
}
