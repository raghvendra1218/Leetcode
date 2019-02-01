package com.raghvendra;

public class MergeTwoSortedLists {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode dummyHead = new ListNode(0);
        ListNode newHead = dummyHead;
        if(curr1 == null) return curr2;
        if(curr2 == null) return curr1;

        while (curr1 != null && curr2 !=null){
            if(curr1.val <= curr2.val){
                dummyHead.next = curr1;
                dummyHead = curr1;
                curr1 = curr1.next;
            } else {
                dummyHead.next = curr2;
                dummyHead = curr2;
                curr2 = curr2.next;
            }
            if(curr1 == null){
                dummyHead.next = curr2;
            } else if(curr2 == null){
                dummyHead.next = curr1;
            }
        }
        return newHead.next;
    }
}
