package com.raghvendra;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

/*    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> nodeValues = new ArrayList<>();
        Stack<List<Integer>> storage = new Stack<>();

        if(root == null) return result;

        LinkedList<TreeNode> current  = new LinkedList<>();
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
              storage.push(nodeValues);
              nodeValues = new ArrayList<>();
            }
        }
//        while(!storage.isEmpty()) result.add(storage.pop()); // Time Complexity increases
        int  i = storage.size()-1;
        for(;i>=0;--i){
            result.add(storage.get(i));
        }
        return result;
    }*/

    /**
    Approach -2 Using one Queue
     */

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<>();

        if(root == null) return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(0, subList);
        }
        return wrapList;
    }
}
