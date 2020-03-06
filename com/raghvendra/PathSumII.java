package com.raghvendra;

import java.util.*;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given the below binary tree and sum = 22,
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * Return:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class PathSumII {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
/**
 * Approach 1: Iterative way, Maintain a stack whenever there is a right branch to the tree in stack along with the sum till that point
 * we are keeping those nodes in stack so that we can come and see any possible path which could lead us to target sum.
 * Solution not implemented yet, need to work on it.
 */
/*    private class ExecutionPath {
        int sum;
        TreeNode node;
        List<Integer> path;

        ExecutionPath(int sum, TreeNode node) {
            this.sum = sum;
            this.node = node;
            path = new ArrayList<>(Arrays.asList(node.val));
        }

        ExecutionPath(int sum, TreeNode node, List<Integer> path) {
            this.sum = sum;
            this.node = node;
            this.path = path;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<ExecutionPath> s = new Stack<>();
        s.push(new ExecutionPath(root.val, root));
        while (!s.isEmpty()) {
            ExecutionPath ep = s.pop();
            TreeNode curr = ep.node;
            int currSum = ep.sum;
            List<Integer> currPath = ep.path;
            while (curr != null) {
                if (curr.left != null && curr.right != null) {
                    currSum += curr.val;
                    currPath.add(curr.val);
                    List<Integer> nextPath = new ArrayList<>(currPath);
                    nextPath.add(curr.right.val);
                    System.out.println(Arrays.toString(nextPath.toArray()));
                    s.push(new ExecutionPath(currSum, curr.right, nextPath));
                    curr = curr.left;
                } else if (curr.left != null) {
                    curr = curr.left;
                    currSum += curr.val;
                    currPath.add(curr.val);
                } else if (curr.right != null) {
                    curr = curr.right;
                    currSum += curr.val;
                    currPath.add(curr.val);
                } else {
                    if (currSum == sum) {
                        result.add(currPath);
                    }
                }
            }
        }
        return result;
    }*/

/**
 * Second Approach - Backtracking, try oit with all possible paths and keep those where you find the answer.
 */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currResult = new ArrayList<>();
        pathSum(root, result, currResult, sum);
        return result;
    }

    private void pathSum(TreeNode root, List<List<Integer>> result, List<Integer> currResult, int sum) {
        //Base conditions
        //condition 1: If root becomes null, we will return from function
        if(root == null) {
            return;
        }
        //Add the current node(root) in the currentResult list, as this could lead us to answer - basic Backtracking way of finding solution
        currResult.add(root.val);
        //condition 2: If root's left and root's right is null (means we are at leaf node) at this point if sum value is equal to root's value,
        //that means we found the root to leaf branch which equals to target sum.
        if(root.left == null && root.right == null && sum == root.val) {
            result.add(new ArrayList<>(currResult)); //we are not returning because at this point else will not execute and as per backtracking rule
            //we need to remove the last element in the list and continue recursion for our remaining node, that will be taken care in the last line of function,
            //as it is common to both if and else block.
        } else {
            //we will continue to traverse the tree and subtract the root's value from sum to keep the track of the sum for above condition
            pathSum(root.left, result, currResult, sum - root.val);
            pathSum(root.right, result, currResult, sum - root.val);
        }
        //Remove the last element from the list to continue the backtracking process
        currResult.remove(currResult.size() - 1);
    }
}
