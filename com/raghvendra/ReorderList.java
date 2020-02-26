package com.raghvendra;
/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

 */

public class ReorderList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        //Step 1: Find the middle of the LL
        //Currently the LL is : 1->2->3->4
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //Step 2: Pointer curr will be a the middle of the LL, Reverse half of the LL
        ListNode curr = slow;
        ListNode newHead = null;
        while(curr != null){
            ListNode fwd = curr.next;
            curr.next = newHead;
            newHead = curr;
            curr = fwd;
        }

        //Step 3: create the List, taking one element from head and one element from newHead
        //Currently the LL is : 1->2->4->3
        curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            ListNode temp1 = (newHead != null) ? newHead.next : null;
            curr.next = newHead;
            if(newHead != null)newHead.next = temp;
            curr = temp;
            newHead = temp1;
        }
    }

}
