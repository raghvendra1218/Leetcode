package com.raghvendra;

import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree {
    static int counter = 0;
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    /**
     * Approach 1: Using Map and then sorting the values in the bucket
     */

//    public int[] findMode(TreeNode root) {
//        Map<Integer,Integer> result = new HashMap<>();
//        result = inOrder(root, result);
////        System.out.println(result);
//        List<Integer>[] bucket = new List[counter+1];
//        for(int i : result.keySet()){
//            int frequency = result.get(i);
//            if(bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
//            bucket[frequency].add(i);
//        }
//
//        //Traverse through bucket and return the values present at the index which is not null from the last
//        for(int pos = bucket.length-1; pos>=0; pos--){
//            if(bucket[pos]!= null){
//                int lengthList = bucket[pos].size();
//                int count = 0;
//                int[] resultfinal = new int[lengthList];
//                for(Integer i : bucket[pos]){
//                    resultfinal[count] = i;
//                    count++;
//                }
//                return resultfinal;
//            }
//        }
//        return new int[0];
//    }
//
//    private Map<Integer,Integer> inOrder(TreeNode root, Map<Integer,Integer> result){
//        if(root!=null){
//            inOrder(root.left,result);
//            result.put(root.val, result.getOrDefault(root.val,0)+1);
//            counter++;
//            inOrder(root.right,result);
//        }
//        return result;
//    }
    /**
     * Approach -2 Just Taking Local variables and keeping the frequency count of previous and current root
     */
    List<Integer> ans = new ArrayList<>();
    Integer pre;
    int maxFreq = 0, curFreq = 0;
    public int[] findMode(TreeNode root) {
        traverse(root);
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) res[i] = ans.get(i);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        //inorder traversal
        traverse(root.left);
        if (pre != null && root.val == pre) {
            curFreq++;
        } else {
            curFreq = 1;
        }
        if (curFreq == maxFreq) {
            ans.add(root.val);
        } else if (curFreq > maxFreq) {
            maxFreq = curFreq;
            ans = new ArrayList<>();
            ans.add(root.val);
        }

        pre = root.val;
        traverse(root.right);
    }
}
