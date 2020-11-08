package com.raghvendra;

public class RemoveLinkedListElements {
    private class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;

        while(head != null) {
            if(head.val == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;
        }

        return dummy.next;
    }
}
