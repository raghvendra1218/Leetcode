package com.raghvendra;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SecondMinimumNodeInBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public int findSecondMinimumValue(TreeNode root) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> mySet = new HashSet<>();
        mySet = inOrder(root, mySet);
        int k = 2, result = 0;
        System.out.println(mySet);
        if(mySet.size() < k) return -1;
        for(Integer i : mySet){
            pq.add(i);
        }
        while(k > 0){
            result = pq.poll();
            k--;
        }
        return result;
    }

    private Set<Integer> inOrder(TreeNode root, Set<Integer> mySet){
        if(root != null){
            inOrder(root.left,mySet);
            mySet.add(root.val);
            inOrder(root.right,mySet);
        }
        return mySet;
    }
}
