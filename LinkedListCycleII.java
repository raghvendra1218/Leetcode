package com.raghvendra;

public class LinkedListCycleII {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode tortoise = head;
        ListNode hare = head;

        while(hare != null || hare.next != null){
            tortoise = tortoise.next;
            hare = hare.next.next;
            if(hare == tortoise){
                tortoise = head;
                while(tortoise != hare){
                    tortoise = tortoise.next;
                    hare = hare.next;
                }
                return tortoise;
            }
        }
        return null;
    }
}
