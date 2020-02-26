package com.raghvendra;

public class IntersectionOfTwoLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;
        int lengthA = 0;
        int lengthB = 0;
        int diff = 0;
        ListNode lastElementA = null;
        ListNode lastElementB = null;

        //Calculate the length of ListA
        while (currA != null){
            lengthA ++;
            currA = currA.next;
        }

        //Keeping the track for the last element in List A
        //Assigning the currA back to Head of List A
        lastElementA = currA;
        currA = headA;

        //Calculate the length of ListA
        while(currB != null){
            lengthB++;
            currB = currB.next;
        }

        //Keeping the track for the last element in List B
        //Assigning the currA back to Head of List B
        lastElementB = currB;
        currB = headB;

        //check if the list ever meet or not , by comparing the last elements of lists
        if(lastElementB != lastElementA) return null;
        //If Lists intersect then advance the longer list by the difference
        else {
            if(lengthA > lengthB) {
                diff = lengthA - lengthB;
                currA = headA;
                for (int i = 1; i <=diff; i++) {
                    currA = currA.next;
                }
            } else {
                diff = lengthB - lengthA;
                currB = headB;
                for(int i = 1; i <=diff; i++){
                    currB = currB.next;
                }
            }

            //Now both the lists will meet at one point which we have to return
            while(currA != currB) {
                currA = currA.next;
                currB = currB.next;
            }
            return currB;
        }
    }
}
