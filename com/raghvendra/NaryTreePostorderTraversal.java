package com.raghvendra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NaryTreePostorderTraversal {
    class Node {
        private int val;
        private List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return  result;
        Stack<Node> myStack = new Stack<>();

        myStack.add(root);

        while (!myStack.isEmpty()){
            Node node = myStack.pop();
            result.add(node.val);
            if(node.children !=null ){
                for(Node n : node.children){
                    myStack.push(n);
                }
            }
        }
        Collections.reverse(result);
        return result;
    }
}
