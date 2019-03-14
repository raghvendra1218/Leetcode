package com.raghvendra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NaryTreePreorderTraversal {
    private class Node {
        private int val;
        private List<Node> children;

        public Node() {
        }

        ;

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * Approach 1:  Iterative Solution
     */
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<Node> myStack = new Stack<>();

        myStack.push(root);

        while (!myStack.isEmpty()) {
            Node node = myStack.pop();
            result.add(node.val);
            if (node.children != null) {
                Collections.reverse(node.children);
                for (Node n : node.children) {
                    myStack.push(n);
                }
                // This will also work , However collection.reverse is bit fast rather than applying whole reverse loop
//              int i = node.children.size() -1;
//                while(i >=0){
//                    myStack.push(node.children.get(i));
//                    i--;
//                }
            }
        }
        return result;
    }
    /**
     * Approach 2: Recursive Solution
     */
//    List<Integer> result = new ArrayList<>();
//
//    public List<Integer> preorder(Node root) {
//        if (root == null) return result;
//        result.add(root.val);
//        for (Node n : root.children) {
//            preorder(n);
//        }
//        return result;
//    }
}

