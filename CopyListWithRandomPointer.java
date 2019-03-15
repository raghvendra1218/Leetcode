package com.raghvendra;

public class CopyListWithRandomPointer {
    private class Node{
        int val;
        Node next;
        Node random;
        public Node() {}
        public Node(int _val, Node _next, Node _random){
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node curr = head;
        Node newHead = new Node(curr.val, null, null);
        Node newCurr = newHead;
//        Node newRand = null;
        //creating a new Linked List with rand pointer as null
        while(curr != null){
            curr = curr.next;
            Node newNode = new Node(curr.val, null, null);
            newCurr.next = newNode;
            newCurr = newNode;
        }

        //initialising the curr back to head
        curr = head;
        Node prevCurr = head;
        newCurr = newHead;

        //Pointing the next pointer of original linked list to the newly created list
        while(curr != null){
            curr = curr.next;
            prevCurr.next = newCurr;
            prevCurr = curr;
            newCurr = newCurr.next;
        }

        curr = head;
        newCurr = head;
        //Now connect the random pointers to respective nodes
        while(curr != null){
            newCurr.random = curr.random.random.next;
            curr = curr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }
}
