package com.raghvendra;

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.
 *
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The longest consecutive path need to be from parent to child (cannot be the reverse).
 *
 * Example 1:
 *
 * Input:
 *
 *    1
 *     \
 *      3
 *     / \
 *    2   4
 *         \
 *          5
 *
 * Output: 3
 *
 * Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
 * Example 2:
 *
 * Input:
 *
 *    2
 *     \
 *      3
 *     /
 *    2
 *   /
 *  1
 *
 * Output: 2
 *
 * Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.
 */
public class BinaryTreeLongestConsecutiveSequence {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        int[] max = new int[1];

        //Traverse through tree, with target and count both as zero
        findLongestConsecutive(root, 0, 0, max);
        return max[0];
    }

    private void findLongestConsecutive(TreeNode root, int count, int target, int[] max) {
        //Base conditions
        if (root == null) return;
        if(root.val == target) {
            count++;
        } else {
            //means we are unable to find the next consecutive number, hence reset the count to 1
            count = 1;
        }

        //Update the max value
        max[0] = Math.max(max[0], count);
        //recurse on the left
        findLongestConsecutive(root.left, count, root.val + 1, max);
        findLongestConsecutive(root.right, count, root.val + 1, max);
    }

}
