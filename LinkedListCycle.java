package com.raghvendra;

public class LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode hare = head;
        ListNode tortoise = head;

        while(hare != null && hare.next != null){
            tortoise = tortoise.next;
            hare = hare.next.next;
            if(hare == tortoise) return true;
        }
        return false;
    }
}
