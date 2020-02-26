package com.raghvendra;

public class RemoveNthNodeFromEndOFfList {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        ListNode prev = null;
        ListNode advCurr = dummy;
        int counter = 1;
        while(advCurr != null){
            if(counter > n){
                prev = curr;
                curr = curr.next;
            }
            advCurr = advCurr.next;
            counter++;
        }
        prev.next = curr.next;
        curr.next = null;
        return dummy.next;
    }
}
