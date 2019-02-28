package com.raghvendra;

public class CopyListWithRandomPointer {
    private class Node{
        int val;
        Node next;
        Node random;
        public Node() {}
        public Node(int _val, Node _next, Node _random){
            val = _val;
            next = _next;
            random = _random;
        }
    }

//    public Node copyRandomList(Node head) {
//        if(head == null) return null;
//        Node oldListPointer =  head;
//        Node newListHead = new Node();
//        newListHead.val = head.val;
//        Node currentListPointer = newListHead;
//        Node previousListPointer = newListHead;
//        while(oldListPointer != null){
//            oldListPointer = oldListPointer.next;
//            Node temp = new Node();
//            temp.val = oldListPointer.val;
//            currentListPointer.next = temp;
//            temp.next =
//            currentListPointer = currentListPointer.next;
//        }
//
//    }
}
