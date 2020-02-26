package com.raghvendra;

import java.util.HashMap;
import java.util.Map;

/**
 * Approach :
 * The basic idea is here:
 * Say we have 2 arrays, PRE and IN.
 * Preorder traversing implies that PRE[0] is the root node.
 * Then we can find this PRE[0] in IN, say it's IN[5].
 * Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
 */

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    /**
     * Approach 1 : Using recursion and creating left and right subTree
     * @param preorder
     * @param inorder
     * @return
     */

/*    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // PreOrder --> Root, Left, Right
        // InOrder --> Left, Root, Right
        return helper(0,0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
        //Base Case
        if(preStart > preorder.length  - 1 || inStart > inEnd){
            return null;
        }
        //Create the node, with value at the preStart
        TreeNode root = new TreeNode(preorder[preStart]);

        //Find the index of this current node in Inorder array
        int currInIndex = 0;
        for(int i = 0; i < inorder.length; ++i){
            if(root.val == inorder[i]){
                currInIndex = i ;
            }
        }

        //Create the left sub tree and right subtree for the current root
        root.left = helper(preStart + 1, inStart, currInIndex - 1, preorder, inorder);
        root.right = helper(preStart + (currInIndex - inStart + 1),currInIndex + 1, inEnd, preorder, inorder);
        return root;
    }*/

    /**
     * Approach 2: We can optimize finding the index of the current node by putting the values and index in a map
     * @param preorder
     * @param inorder
     * @return
     */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // PreOrder --> Root, Left, Right
        // InOrder --> Left, Root, Right
        Map<Integer, Integer> myMap = new HashMap<>();
        for(int i = 0; i < inorder.length; ++i){
            myMap.put(inorder[i], i);
        }
        return helper(0,0,inorder.length - 1, myMap, inorder, preorder);
    }

    private TreeNode helper(int preStart, int inStart, int inEnd, Map<Integer, Integer>myMap, int[] inorder, int[] preorder){
        //Base Case
        if(preStart > preorder.length - 1 || inStart > inEnd){
            return null;
        }

        //Create the root node
        TreeNode root = new TreeNode(preorder[preStart]);
        int currRootIdx = myMap.get(root.val);

        //Create the left subtree and right subtree
        root.left = helper(preStart + 1, inStart, currRootIdx - 1, myMap, inorder, preorder);
        root.right = helper(preStart + (currRootIdx - inStart + 1), currRootIdx + 1, inEnd, myMap, inorder, preorder);
        return root;
    }
}
