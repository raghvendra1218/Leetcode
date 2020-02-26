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

    /*public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node curr = head;
        Node newHead = null;
        Node newCurr = null;

        //Step 1: creating a new Linked List with rand pointer as null
        while(curr != null){
            Node newNode = new Node(curr.val, null, null);
            if(newHead == null){
                newHead = newNode;
                newCurr = newHead;
            } else {
                newCurr.next = newNode;
                newCurr = newCurr.next;
            }
            curr = curr.next;
        }

        //initialising the curr and NewCurr back to respective heads
        curr = head;
        newCurr = newHead;

        //Step 2: Point the random pointer of cloned link list to the original link list
        while(newCurr != null){
            newCurr.random = curr;
            newCurr = newCurr.next;
            curr = curr.next;
        }

        //initialising the curr back to head
        curr = head;
        Node prevCurr = head;
        newCurr = newHead;

        //Step 3: Pointing the next pointer of original linked list to the newly created list
        while(curr != null){
            curr = curr.next;
            prevCurr.next = newCurr;
            prevCurr = curr;
            newCurr = newCurr.next;
        }

        //initialising the curr and NewCurr back to respective heads
        curr = head;
        newCurr = newHead;

        //Step 4: Connect the random pointers to respective nodes
        while(newCurr != null){
            newCurr.random = newCurr.random.random.next;
//            curr = curr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }*/

    /**
     * Approach 2 : does not modifies the Original List, and that's the intention here
     * Intuition : Add the duplicate nodes in between the original list and assign the random pointer to the next of the original random pointers
     * Separate the Original and new Linked List
     */

    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node curr = head;
        Node newHead = null;
        Node fwd = null;

        //iterate through the original list and add the new duplicate nodes in between with rand pointer as null for them
        while(curr != null){
            Node node = new Node(curr.val, null, null);
            if(newHead == null){
                newHead = node;
            }
            fwd = curr.next;
            curr.next = node;
            node.next = fwd;
            curr = fwd;
        }

        //initialise the curr back to the head of the Original List
        curr = head;

        //iterate through the modified list and now assign the random pointers for inserted nodes
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            } else {
                curr.next.random = null;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node newCurr = newHead;

        //Now separate the original and duplicate list
        while(curr != null){
            curr.next = curr.next.next;
            newCurr.next = (newCurr.next != null) ? newCurr.next.next: null;
            curr= curr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }
}
