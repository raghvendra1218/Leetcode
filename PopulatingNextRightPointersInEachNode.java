package com.raghvendra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PopulatingNextRightPointersInEachNode {
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        List<Node> nodeValues = new ArrayList<>();

        if(root == null) return root;

        //Create two List to store the current and next level values (Nodes)
        LinkedList<Node> current = new LinkedList<>();
        LinkedList<Node> next = new LinkedList<>();

        //Store the root value into the node, to start the traversal
        current.add(root);

        //Check the Node values until the current list is empty
        while(!current.isEmpty()){
            Node node = current.remove();

            if(node.left != null){
                next.add(node.left);
            }
            if(node.right != null){
                next.add(node.right);
            }

            nodeValues.add(node);

            if(current.isEmpty()){
                current = next;
                next = new LinkedList<>();
                for(int i = 0; i <nodeValues.size(); ++i){
                    if(i != (nodeValues.size()-1)){
                        nodeValues.get(i).next = nodeValues.get(i+1);
                    } else {
                        nodeValues.get(i).next = null;
                    }
                }
            }
        }
        return root;
    }
}
