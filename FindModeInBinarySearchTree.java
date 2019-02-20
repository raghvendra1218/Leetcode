package com.raghvendra;

import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public int[] findMode(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        result = inOrder(root, result);
        System.out.println(result);
        int[] resultfinal = new int[result.size()];
        return resultfinal;
//        return result.toArray(resultfinal);
    }

    private List<Integer> inOrder(TreeNode root, List<Integer> result){
        if(root!=null){
            inOrder(root.left,result);
            result.add(root.val);
            inOrder(root.right,result);
        }
        return result;
    }
}
