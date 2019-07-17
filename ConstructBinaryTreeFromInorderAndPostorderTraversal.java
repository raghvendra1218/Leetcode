package com.raghvendra;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    /**
     * Approach 1 : Using Recursion, no optimisation
     * @param inorder
     * @param postorder
     * @return
     */
/*    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //InOrder --> Left, Root, Right
        //PostOrder --> Left, Right, Root
        return helper(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }

    private TreeNode helper(int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder){
        //Base Case
        if(postEnd < 0 || inStart > inEnd){
            return null;
        }

        //Create the current root
        TreeNode root = new TreeNode(postorder[postEnd]);
        //Find the index of the root in the inorder array
        int currRootIdx = 0;
        for(int i = 0; i < inorder.length; ++i){
            if(inorder[i] == root.val){
                currRootIdx = i;
                break;
            }
        }

        //Create the left subtree and right subtree around the current root
        root.left = helper( postEnd - (inEnd - currRootIdx) - 1, inStart, currRootIdx - 1, inorder, postorder);
        root.right = helper(postEnd - 1, currRootIdx + 1, inEnd , inorder, postorder);
        return root;
    }*/

    /**
     * Approach 2: Optimizing it through HashMap by storing values and Index for inorder array
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //InOrder --> Left, Root, Right
        //PostOrder --> Left, Right, Root
        Map<Integer, Integer> myMap = new HashMap<>();
        for(int i = 0; i < inorder.length; ++i){
            myMap.put(inorder[i], i);
        }
        return helper(postorder.length - 1, 0, inorder.length - 1, inorder, postorder, myMap);
    }

    private TreeNode helper(int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder, Map<Integer, Integer> myMap) {
        //Base Case
        if (postEnd < 0 || inStart > inEnd) {
            return null;
        }

        //Create the current root
        TreeNode root = new TreeNode(postorder[postEnd]);
        //Find the index of the root in the inorder array
        int currRootIdx = myMap.get(root.val);

        //Create the left subtree and right subtree around the current root
        root.left = helper(postEnd - (inEnd - currRootIdx) - 1, inStart, currRootIdx - 1, inorder, postorder, myMap);
        root.right = helper(postEnd - 1, currRootIdx + 1, inEnd, inorder, postorder, myMap);
        return root;
    }

}
