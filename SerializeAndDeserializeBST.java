package com.raghvendra;

public class SerializeAndDeserializeBST {
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
        StringBuilder result = new StringBuilder();
        result = preOrder(root, result);
//        System.out.println(result);
        return new String(result);
    }

    private StringBuilder preOrder(TreeNode root, StringBuilder result){
        if(root != null){
            result.append(root.val);
            result.append(" ");
            preOrder(root.left,result);
            preOrder(root.right,result);
        }
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()<1)return null;
        data = data.trim();
        String[] numbers = data.split(" ");
        int low = 0;
        int high = numbers.length -1;
        return deserial(numbers, low, high);
    }

    private TreeNode deserial(String[] data, int low, int high){
        if(low > high) return null;
        TreeNode root = new TreeNode(Integer.parseInt(data[low]));
        int divIdx = divIndex(data, root.val, low, high);
        root.left = deserial(data, low+1, divIdx -1);
        root.right = deserial(data,divIdx,high);
        return root;
    }

    private int divIndex(String[] data, int value, int low, int high){
        int i;
        for( i = low; i<= high; ++i){
            if(value < Integer.parseInt(data[i])){
                break;
            }
        }
        return i;
    }
}
