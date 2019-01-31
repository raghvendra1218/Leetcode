package com.raghvendra;

public class ReverseLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode forward = null;
        ListNode previous = null;
        while(current != null){
            forward = current.next;
            current.next = previous;
            previous = current;
            current = forward;
            head = previous;
        }
        return head;
    }
}