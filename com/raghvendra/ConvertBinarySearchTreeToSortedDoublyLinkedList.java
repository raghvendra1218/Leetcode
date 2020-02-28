package com.raghvendra;

/**
 * Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
 * You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list. For a circular doubly linked list,
 * the predecessor of the first element is the last element, and the successor of the last element is the first element.
 * We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor,
 * and the right pointer should point to its successor. You should return the pointer to the smallest element of the linked list.
 * Example 1:
 * Input: root = [4,2,5,1,3]
 * Output: [1,2,3,4,5]
 * Explanation: The figure below shows the transformed BST. The solid line indicates the successor relationship, while the dashed line means the predecessor relationship.
 * Example 2:
 * Input: root = [2,1,3]
 * Output: [1,2,3]
 * Example 3:
 * Input: root = []
 * Output: []
 * Explanation: Input is an empty tree. Output is also an empty Linked List.
 * Example 4:
 * Input: root = [1]
 * Output: [1]
 * Constraints:
 * -1000 <= Node.val <= 1000
 * Node.left.val < Node.val < Node.right.val
 * All values of Node.val are unique.
 * 0 <= Number of Nodes <= 2000
 */
public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    class Node {
        private int val;
        private Node left;
        private Node right;

        private Node() {
            //NOOP
        }

        private Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
/**
    Solution 1 : I did the problem, without doing it in-place, but question asks for modifying the tree in place and convert it into Linked List
                 Here, I started with head and tail, did the inOrder traversal of tree and created the Linked List while traversal, at last joined the links to
                 head and tail to make it circular linked list.
 */
    public Node treeToDoublyList(Node root) {
        Node head = new Node();
        Node tail = new Node();
        head.right = tail;
        head.left = null;
        tail.left = head;
        tail.right = null;
        if (root == null) return null;
        inOrderTraversalOfBSTWithListCreation(root, head, tail);
        //Join the last node(which is left to tail) to the first node(which is right to head), in order to make it circular
        tail.left.right = head.right;
        head.right.left = tail.left;
        return head.right;
    }

    //Traverse the Tree and create the linked list in place
    private void inOrderTraversalOfBSTWithListCreation(Node node, Node head, Node tail) {
        if (node != null) {
            inOrderTraversalOfBSTWithListCreation(node.left, head, tail);
            Node currentNode = new Node(node.val, null, null);
            //condition to check if the node belongs to the head of the Linked List
            if (head.right == tail) {
                head.right = currentNode;
                currentNode.left = head;
                currentNode.right = tail;
                tail.left = currentNode;
            } else {
                currentNode.left = tail.left;
                currentNode.right = tail;
                tail.left = currentNode;
                currentNode.left.right = currentNode;
            }
            inOrderTraversalOfBSTWithListCreation(node.right, head, tail);
        }
    }

    /**
     * Solution 2: Doing it in-place, without having to create an additional List
     */
    Node first = null;
    Node last = null;
    public Node treeToDoublyList2(Node root) {
        if(root == null) return null;
        helper(root);
        //Make it circular linked List
        last.right = first;
        first.left = last;
        return first;
    }

    private void helper(Node node) {
        if(node != null) {
            //Traverse to the extreme left
            helper(node.left);
            //If there are more than one nodes traversed, that will imply last is not null and it is safe to weave the node
            if(last != null) {
                //Link the previous node (last), with the current node (node)
                last.right = node;
                node.left = last;
            } else {
                //keep the head node to link the last node, later
                //This block will run only once, during the first run, when last is null
                first = node;
            }
            //assign the current node to last
            last = node;
            //right
            helper(node.right);
        }
    }

    /**
     * Solution 3: Doing it in-place, without having to create an additional List
     */
    Node prev = null;
    public Node treeToDoublyList3(Node root) {
        if (root == null) return null;
        Node dummy = new Node();
        prev = dummy;
        inOrderTraversalOfBST(root);
        //Join the last node(which is left to tail) to the first node(which is right to head), in order to make it circular
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy.right;
    }

    //Traverse Binary Search tree and add the connections
    private void inOrderTraversalOfBST(Node curr) {
        if(curr != null){
            inOrderTraversalOfBST(curr.left);
            prev.right = curr;
            curr.left = prev;
            prev = curr;
            inOrderTraversalOfBST(curr.right);
        }
    }
}
