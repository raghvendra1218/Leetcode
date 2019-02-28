package com.raghvendra;

import java.util.*;

public class VerticalOrderTraversalOfBinaryTree {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> nodeValues = new ArrayList<>();
//
//        if(root == null) return  result;
//
//        //Create two LinkedList in order to store the level values in each level
//        LinkedList<TreeNode> current = new LinkedList<>();
//        LinkedList<TreeNode> next = new LinkedList<>();
//
//        //Create a variable to store the Horizontal distance of each node from the leftmost part of the tree, taking HD of root equals to be zero
//        //Store the Horzontal Distance in a HashMap
//        int horizontalDistance = 0;
//        Map<TreeNode, Integer> myMap = new LinkedHashMap<>();
//        myMap.put(root,0);
//        //Create a variable to store the root value and begin the process of traversal
//        TreeNode node = root;
//        current.addFirst(node);
//        int countOfNodes = 0;
//
//        //Traverse through the Tree until the current List is empty
//        while(!current.isEmpty()){
//            node = current.remove();
//            countOfNodes++;
//
//            if(node.left != null){
//                next.add(node.left);
//                horizontalDistance = myMap.get(node) - 1;
//                myMap.put(node.left, horizontalDistance);
//            }
//            if(node.right != null){
//                next.add(node.right);
//                horizontalDistance = myMap.get(node) + 1;
//                myMap.put(node.right, horizontalDistance);
//            }
//            if(current.isEmpty()){
//                current = next;
//                next = new LinkedList<>();
//            }
//        }
//
//        int normalizationfactor = Collections.min(myMap.values());
//        List<Integer>[] bucket = new List[countOfNodes];
//        for(TreeNode n : myMap.keySet()){
//            int frequency = myMap.get(n) - normalizationfactor;
//            if(bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
//            bucket[frequency].add(n.val);
//        }
//
//        for(int pos = 0; pos<countOfNodes; pos++){
//            if(bucket[pos] != null){
//                for(int i : bucket[pos]){
//                    nodeValues.add(i);
//                }
//                result.add(nodeValues);
//                nodeValues = new ArrayList<>();
//            }
//        }
//        return result;

        /** Approach -2 : Simplify work by taking List of Nodes in HashMap */
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> nodeValues = new ArrayList<>();

        if(root == null) return  result;

        //Create two LinkedList in order to store the level values in each level
        LinkedList<TreeNode> current = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();

        //Create a variable to store the Horizontal distance of each node from the leftmost part of the tree, taking HD of root equals to be zero
        //Store the Horzontal Distance in a HashMap

        //Create a variable to store the root value and begin the process of traversal
        TreeNode node = root;
        current.add(node);

        //Traverse through the Tree until the current List is empty


        return result;
    }
}
