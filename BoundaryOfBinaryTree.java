package com.raghvendra;

import java.util.ArrayList;
import java.util.List;

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
        if(root == null) return result;
        result.add(root.val);
        result = travelLeftTreeWithoutLeaf(root.left, result);
        result = travelLeafNodes(root.left, result);
        result = travelLeafNodes(root.right, result);
        result =  travelRightTreeWithoutLeaf(root.right, result);
        return result;
    }

    private List<Integer> travelLeftTreeWithoutLeaf(TreeNode root, List<Integer> result){

        //condition to check if the node is not leaf node and node is not null
        if(root == null || (root.left == null && root.right == null)){
            return result;
        }
        result.add(root.val);
        if(root.left != null){
            travelLeftTreeWithoutLeaf(root.left,result);
        } else {
            travelLeftTreeWithoutLeaf(root.right,result);
        }
        return result;
    }

    private List<Integer> travelLeafNodes(TreeNode root, List<Integer> result){

        //
        if(root != null){
            //add the leaf nodes in the result list
            if(root.left == null && root.right == null){
                result.add(root.val);
            }
            travelLeafNodes(root.left, result);
            travelLeafNodes(root.right, result);
        }
        return result;
    }

    private List<Integer> travelRightTreeWithoutLeaf(TreeNode root, List<Integer> result){

        if(root == null || (root.left == null && root.right == null)){
            return result;
        }
        if(root.right != null){
            travelRightTreeWithoutLeaf(root.right,result);
        } else{
            travelRightTreeWithoutLeaf(root.left, result);
        }
        result.add(root.val);

        return result;
    }
}
