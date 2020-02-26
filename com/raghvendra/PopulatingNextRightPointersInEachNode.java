package com.raghvendra;
/**
 You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

 struct Node {
 int val;
 Node *left;
 Node *right;
 Node *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.



 Example:



 Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}

 Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}

 Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B.


 Note:

 You may only use constant extra space.
 Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 */
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
//        List<Node> nodeValues = new ArrayList<>();
//
//        if(root == null) return root;
//
//        //Create two List to store the current and next level values (Nodes)
//        LinkedList<Node> current = new LinkedList<>();
//        LinkedList<Node> next = new LinkedList<>();
//
//        //Store the root value into the node, to start the traversal
//        current.add(root);
//
//        //Check the Node values until the current list is empty
//        while(!current.isEmpty()){
//            Node node = current.remove();
//
//            if(node.left != null){
//                next.add(node.left);
//            }
//            if(node.right != null){
//                next.add(node.right);
//            }
//
//            nodeValues.add(node);
//
//            if(current.isEmpty()){
//                current = next;
//                next = new LinkedList<>();
//                for(int i = 0; i <nodeValues.size(); ++i){
//                    if(i != (nodeValues.size()-1)){
//                        nodeValues.get(i).next = nodeValues.get(i+1);
//                    } else {
//                        nodeValues.get(i).next = null;
//                    }
//                }
//            }
//        }
//        return root;

        /**
         * Approach - for root we don't have to worry, Since it is a perfect binary tree means each node will have two child
         * we will travel each level and at the same time cover each level from left to right
         */
        if(root == null) return root;
        Node curr = root;
        //iterating in depth
        while(curr != null){
            //iterating in level for each depth/curr node
            Node levelNode = curr;
            while(levelNode != null){
                //check if levelnode's left is not null
                if(levelNode.left != null){
                    levelNode.left.next = levelNode.right;
                }
                //check if the right node lies in between of tree, basically right nodes except the extreme right nodes
                if(levelNode.right != null && levelNode.next != null){
                    levelNode.right.next = levelNode.next.left;
                }
                levelNode = levelNode.next;
            }
            curr = curr.left;
        }
        return root;
    }
}
