package com.raghvendra;

/**
 * There will be three cases here and we will have to deal with them all
 * Case 1: If node to be deleted is leaf Node, then simply delete the Node
 * Case 2: If node to be deleted has just one child (does n't matter left/right) but has just one child, in that case delete that node
 * and move up/replace the entire child and it's subtree(if if present) with the deleted node position
 * Case 3: If the node to be deleted has two child, then
 */
public class DeleteNodeInABST {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;

        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else {
            if(root.left == null){
                TreeNode temp = root.right;
                return temp;
            }
            if(root.right == null){
                TreeNode temp = root.left;
                return temp;
            }

            //Case when both child exists
            TreeNode temp = root.right;
            while(temp.left != null){
                temp = temp.left;
            }
            root.val = temp.val;
            root.right = deleteNode(root.right, temp.val);
        }
        return root;
    }
}
