package com.raghvendra;

public class PalindromeLinkedList {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode slow  = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null){  // it implies list is odd, hence advance the slow pointer by one ahead
            slow = slow.next;
        }

        //storing the head of the reversed link list in slow
        slow = reverse(slow);
        fast = head;

        while(slow !=null){
            if(slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    //Algorithm to write the code for reverse of linked List
    private ListNode reverse(ListNode slow){
        ListNode curr = slow;
        ListNode prev = null;
        ListNode forward = null;

        while(curr != null){
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }
}
