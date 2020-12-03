package com.raghvendra;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class LinkedListRandomNode {
    private class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Approach 1: Iterate the entire Linked List in an ArrayList/Map and then simply generate a random number between
     *             the linked list size and 0 to get the random index for return.
     *             Time Complexity : O(n)
     *             Space Complexity : O(n)
     */
    List<Integer> list;
    public LinkedListRandomNode(ListNode head) {
        list = new ArrayList<>();
        ListNode curr = head;
        while(curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
    }

    public int getRandom() {
        int rand = (int)(Math.random() * list.size());
        return list.get(rand);
    }

    /**
     * Approach 2: Constant Space, constraint -> we can use reservoir sampling
     *             The idea is if we have one node then probability is 100%,
     *             If we have 2 nodes, then the probability is 1/2., if 3 then 1/3,
     *             we can write it as : 1/1 * 1/2 * 2/3 * 3/4
     */
    ListNode head = null;
    Random rand = null;
    public void LinkedListRandomNodeI(ListNode head) {  //this is constructor
        this.head = head;
        this.rand = new Random();
    }

    public int getRandomII() {
        int res = -1;
        ListNode t = head;
        for(int i = 1; t != null ; i++) {
            //rand.nextInt(i) - will produce random integer b/w 0 to i - 1 , do a dry for list of size, 2 , things will be more clear
            if(rand.nextInt(i) == i - 1) {
                res = t.val;
            }
            t = t.next;
        }

        return res;
    }
}
