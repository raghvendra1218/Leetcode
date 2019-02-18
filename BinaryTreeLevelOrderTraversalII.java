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

//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> nodeValues = new ArrayList<>();
//        Stack<List<Integer>> storage = new Stack<>();
//
//        if(root == null) return result;
//
//        LinkedList<TreeNode> current  = new LinkedList<>();
//        LinkedList<TreeNode> next = new LinkedList<>();
//
//        current.add(root);
//
//        while(!current.isEmpty()){
//            TreeNode node = current.remove();
//
//            if(node.left != null){
//                next.add(node.left);
//            }
//            if(node.right !=null){
//                next.add(node.right);
//            }
//
//            nodeValues.add(node.val);
//
//            if(current.isEmpty()){
//              current = next;
//              next = new LinkedList<>();
//              storage.push(nodeValues);
//              nodeValues = new ArrayList<>();
//            }
//        }
//        System.out.println(storage);
////        while(storage.size() > 0 && storage.isEmpty()) result.add(storage.pop());
//        int  i = storage.size()-1;
//        for(;i>=0;--i){
//            result.add(storage.get(i));
//        }
//        return result;
//    }

    /*
    Approach -2 Using Queue - currently not working
     */

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> nodeValues = new ArrayList<>();
        Stack<List<Integer>> storage = new Stack<>();

        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        queue.offer(null);

        while(!queue.isEmpty()){
            root = queue.poll();
            if(root != null){
                if(root.left != null){
                    queue.offer(root.left);
                }
                if(root.right !=null){
                    queue.offer(root.right);
                }
                nodeValues.add(root.val);
            } else {

                if (!queue.isEmpty()) {
                    queue.poll();
                    storage.push(nodeValues);
                    nodeValues = new ArrayList<>();
                    queue.offer(null);
                }
            }
        }
        System.out.println(storage);
//        while(storage.size() > 0 && storage.isEmpty()) result.add(storage.pop());
        int  i = storage.size()-1;
        for(;i>=0;--i){
            result.add(storage.get(i));
        }
        return result;
    }
}
