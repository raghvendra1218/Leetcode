package com.raghvendra;

public class ReverseLinkedListII {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        int diff = n - m + 1;
        int counter = 0;
        ListNode dummy = new ListNode(0);
        dummy.next =  head;
        ListNode curr = dummy;
        ListNode prev = null;
        while(curr != null){
            if(counter >= m){
                prev.next = reverse(curr, diff);
                break;
            }
            counter++;
            prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head, int diff){
        int counter = 1;
        ListNode curr  = head;
        ListNode prev =  null;
        ListNode fwd = null;
        while(counter <= diff){
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
            counter++;
        }
        head.next = curr;
        return prev;
    }
}
