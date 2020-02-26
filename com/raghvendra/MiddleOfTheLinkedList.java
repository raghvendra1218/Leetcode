package com.raghvendra;

public class MiddleOfTheLinkedList {

//      Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public ListNode middleNode(ListNode head) {
        ListNode singlePtr = head;
        ListNode doublePtr = head;
        while(doublePtr != null && doublePtr.next != null){  // to handle odd/even number of elements in a list
            singlePtr = singlePtr.next;
            doublePtr = doublePtr.next.next;
        }
        return singlePtr;
    }

}
