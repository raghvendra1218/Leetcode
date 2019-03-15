package com.raghvendra;

import java.util.Stack;

public class AddTwoNumbersII {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    /**
     * Approach 1: By reversing the Link List
     *Time Complexity : O(n)
     * Space Complexity: O(1)
     */
/*    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head_1 = l1;
        ListNode head_2 = l2;
        head_1 = reverseList(l1);
        head_2 = reverseList(l2);
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
        newHead = reverseList(newHead);
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
    }*/

    /**
     * Approach 2: Without rotating the Link List
     *Time Complexity : O(n)
     * Space Complexity: O(n)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> result = new Stack<>();
        int carry = 0;
        ListNode newHead = null;
        ListNode curr = null;

        //Pushing the values from the list 1 to Stack 1, This will ensure the Least Significant digit to be on top of Stack
        while (l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }

        //Pushing the values from the list 2 to Stack 2, This will ensure the Least Significant digit to be on top of Stack
        while (l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }

        //Adding the elements by popping from stack from two list and creating the new Linked List
        while(carry == 1 || !stack1.isEmpty() || !stack2.isEmpty()){
            if(!stack1.isEmpty()){
                carry += stack1.pop();
            } else {
                carry += 0;
            }

            if(!stack2.isEmpty()){
                carry += stack2.pop();
            } else {
                carry += 0;
            }

            result.push(carry % 10);
            carry = carry/10;
        }

        while(!result.isEmpty()){
            ListNode newNode =  new ListNode(result.pop());
            if(newHead == null){
                newHead = newNode;
                curr = newHead;
            } else {
                curr.next = newNode;
                curr = curr.next;
            }
        }
        return newHead;
    }
}
