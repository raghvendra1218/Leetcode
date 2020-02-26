package com.raghvendra;

public class PathSum {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        sum -= root.val;
        if(root.left == null && root.right == null){
            return (sum == 0);
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

//    private int recurse(TreeNode root, int sum){
//        if(root != null){
//            if(sum == 0)return sum;
//            recurse(root.left,sum);
//            recurse(root.right,sum);
//            sum -= root.val;
//        }
//        System.out.println("here");
//        return -1;
//    }
}
