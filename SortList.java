package com.raghvendra;

public class SortList {
    /**
     * Approach: Apply merge sort, cut the list in two halves recursively and merge the halves of the list
     */

    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }


    public ListNode sortList(ListNode head) {
        //Base case
        if(head == null || head.next == null) return head;

        //Step 1 : Cut the list into two halves
        ListNode prev = null, slow = head, fast = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        //At this point the there are two list nodes one with head as head and another with slow pointer as head
        //Step 2: sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        //Step 3 : Merge l1 and l2
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;

        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                newHead.next = l1;
                l1 = l1.next;
            } else {
                newHead.next = l2;
                l2 = l2.next;
            }
            newHead = newHead.next;
        }

        while(l1 != null){
            newHead.next = l1;
            l1 = l1.next;
            newHead = newHead.next;
        }

        while(l2 != null){
            newHead.next = l2;
            l2 = l2.next;
            newHead = newHead.next;
        }

        return dummy.next;
    }
}
