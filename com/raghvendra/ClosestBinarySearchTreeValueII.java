package com.raghvendra;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ClosestBinarySearchTreeValueII {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Math.abs(o1 - target) > Math.abs(o2 - target) ? -1 : 1);
        inOrderTraversal(root, target, k, result, pq);
        return new ArrayList<>(pq);
    }

    private void inOrderTraversal(TreeNode root, double target, int k, List<Integer> result, PriorityQueue<Integer> pq) {
        if(root != null) {
            inOrderTraversal(root.left, target, k, result, pq);
            pq.add(root.val);
            if(pq.size() > k) {
                pq.remove();
            }
            inOrderTraversal(root.right, target, k, result, pq);
        }
    }
}
