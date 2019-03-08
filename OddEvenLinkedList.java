package com.raghvendra;

public class OddEvenLinkedList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even= head.next;
        ListNode evenHead = even;
        int counter = 1;
        while(odd != null && even != null){
            if(counter%2 != 0){
                odd.next = even.next;
                if(even.next == null){
                    odd.next = evenHead;
                    return head;
                }
                odd = odd.next;
            } else {
                even.next = odd.next;
                if(odd.next == null){
                    odd.next = evenHead;
                    return head;
                }
                even = even.next;
            }
            counter++;
        }
        return head;

        /**
         * Approach - 2
         */
/*        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;*/
    }


}
