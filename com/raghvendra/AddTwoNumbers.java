package com.raghvendra;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

public class AddTwoNumbers {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head_1 = l1;
        ListNode head_2 = l2;
//        head_1 = reverseList(l1);
//        head_2 = reverseList(l2);
        ListNode newHead = null;
        ListNode newCurr = null;
        int carry = 0;
        while(carry == 1 || head_1 != null || head_2 != null){
            if(head_1 != null){
                carry += head_1.val;
                head_1 = head_1.next;
            } else {
                carry += 0;
            }
            if(head_2 != null){
                carry += head_2.val;
                head_2 = head_2.next;
            } else {
                carry += 0;
            }
            ListNode node = new ListNode(carry % 10);
            if(newHead == null) {
                newHead = node;
                newCurr = newHead;
            } else{
                newCurr.next = node;
                newCurr = newCurr.next;
            }
            carry = carry/10;
        }
        return newHead;
    }

    private ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode fwd = null;

        while (curr != null){
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }
}
