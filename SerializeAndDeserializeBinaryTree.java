package com.raghvendra;

public class SerializeAndDeserializeBinaryTree {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       StringBuilder serializedTree =  new StringBuilder();
       serializedTree = preOrder(root, serializedTree);
       System.out.println(serializedTree);
       return new String(serializedTree);
    }

    private StringBuilder preOrder(TreeNode root, StringBuilder serializedTree){
        if(root == null){
            serializedTree.append(",");
            serializedTree.append(" ");
        } else {
            serializedTree.append(root.val);
            serializedTree.append(" ");
            preOrder(root.left,serializedTree);
            preOrder(root.right,serializedTree);
        }
        return serializedTree;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() < 1) return null;
        String [] nodes = data.split(" ");
        TreeNode result = deserial(nodes);
        return result;
    }
    int idx = 0;
    private TreeNode deserial(String[] data){
        if(idx == data.length || data[idx].equals(",")){
            idx += 1;
            return null;
        }
        TreeNode root  = new TreeNode(Integer.parseInt(data[idx]));
        idx +=1;
        root.left = deserial(data);
        root.right = deserial(data);
        return root;
    }
}
