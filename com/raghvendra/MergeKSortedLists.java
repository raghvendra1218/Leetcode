package com.raghvendra;

import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        //Create a minHeap for all the nodes from the lists of the Lists
        PriorityQueue<Integer> minHeap =  new PriorityQueue<>();
        //Iterate through all lists and insert in the minHeap
        for(ListNode head : lists){
            while(head != null){
                minHeap.add(head.val);
                head = head.next;
            }
        }

        //Create a dummy node and make it point to head
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        //Create a new List from the PQ
        while (!minHeap.isEmpty()){
            head.next = new ListNode(minHeap.poll());
            head = head.next;
        }
        return dummy.next;
    }
}
