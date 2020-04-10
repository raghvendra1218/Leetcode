package com.raghvendra;

public class DiameterOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Approach 1:  Where we are recursively calculating height and Diameter around that, at each node
     *              Time Complexity = O(nlogn) - good case, when tree is balanced, worst case - O(n^2). In General O(n * Height of Tree)
     */
    public int diameterOfBinaryTree(TreeNode root) {
        int diameter = 0;
        if(root == null) return diameter;

        int option_1 = height(root.left) + height(root.right);
        int option_2 = diameterOfBinaryTree(root.left);
        int option_3 = diameterOfBinaryTree(root.right);
        diameter = Math.max(option_1, Math.max(option_2, option_3));
        return diameter;
    }

    //Helper
    private int height(TreeNode root) {
        //Base case
        if(root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);
        return 1 + Math.max(lh, rh);
    }

    /**
     * Approach 2 : In Approach 1 we have redundant calculation of calculating height again and again during recursive calls.
     *              Here we can reduce the calculation by calculating Height and Diameter through one call on each Node.
     *              For that we will make a class HDPair for calculating height and Diameter, because we want to return both height
     *              and diameter for each Node.
     *
     */
    public class HDPair {
        int height;
        int diameter;

        public HDPair() {
            this.height = 0;
            this.diameter = 0;
        }

        public HDPair(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public int diameterOfBinaryTreeII(TreeNode root) {
        HDPair heightAndDiameter = new HDPair();
        if(root == null) return heightAndDiameter.diameter;

        heightAndDiameter = heightDiameter(root);
        return heightAndDiameter.diameter;
    }

    //helper
    private HDPair heightDiameter(TreeNode root) {
        HDPair output =  new HDPair(); //this sets the height and diameter of the output to be 0 and 0.

        //Base case
        if(root == null) {
            return output;
        }

        //calculate height and diameter for left and right subtrees
        HDPair leftOutput = heightDiameter(root.left);
        HDPair rightOutput = heightDiameter(root.right);

        //Height
        int height = 1 + Math.max(leftOutput.height, rightOutput.height);

        //Diameter
        int diaOption_1 = leftOutput.height + rightOutput.height;
        int diaOption_2 = leftOutput.diameter;
        int diaOption_3 = rightOutput.diameter;
        int diameter = Math.max(diaOption_1, Math.max(diaOption_2, diaOption_3));
        output.height = height;
        output.diameter = diameter;
        return output;
    }
}
