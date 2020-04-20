package com.raghvendra;

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
