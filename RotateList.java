package com.raghvendra;

public class RotateList {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode curr =  head;
        ListNode tail = null;
        int length = 0;
        while(curr != null){
            length++;
            tail = curr;
            curr = curr.next;
        }
        k = k % length;
        curr = head;
        int counter  = length - k;
        while((counter - 1) > 0){ //we have to stop the counter one position before in order to avoid
            System.out.println(length - k);
            curr = curr.next;
            counter--;
        }
        tail.next = head;
        head = curr.next;
        curr.next = null;
        return head;
    }
}
