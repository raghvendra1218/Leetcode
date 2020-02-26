package com.raghvendra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NaryTreeLevelOrderTraversal {
    private class Node {
        private int val;
        private List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        List<Integer> nodeValues =  new ArrayList<>();

        LinkedList<Node> current = new LinkedList<>();
        LinkedList<Node> next =  new LinkedList<>();
        current.add(root);

        while (!current.isEmpty()){
            Node node = current.remove();

            if(node.children != null){
                for(Node n : node.children){
                    next.add(n);
                }
            }

            nodeValues.add(node.val);

            if(current.isEmpty()){
                current = next;
                next = new LinkedList<>();
                result.add(nodeValues);
                nodeValues = new ArrayList<>();
            }
        }
        return result;
    }
}
