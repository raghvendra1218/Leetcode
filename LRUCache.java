package com.raghvendra;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 */

public class LRUCache {

    private class Node {
        int key;
        int value;
        Node next;
        Node prev;
        Node(){};
        Node(int key, int value){
            this.key = key;
            this.value = value;
            next = null;
            prev = null;
        }
    }

    private Map<Integer, Node> myMap;
    private int size  = 0;
    private int capacity = 0;
    private Node head ;
    private Node tail ;

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();

        head.prev = null;
        tail.next = null;
        head.next = tail;
        tail.prev = head;

        this.myMap = new HashMap<>(capacity);
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        Node searchNode = myMap.get(key);
        if(searchNode == null) {
            return -1;
        }

        //Move the accessed Node to the head
        this.moveToHead(searchNode);
        return searchNode.value;
    }

    public void put(int key, int value) {
        Node node = myMap.get(key);
        if(node == null){
            Node newNode = new Node(key, value);
            this.myMap.put(key, newNode);
            this.addNode(newNode);
            size++;

            //check if the size is greater than capacity
            if(size > capacity){
                //pop the tail
                Node tail = this.popTail();
                this.myMap.remove(tail.key);
                size--;
            }
        } else {
            //update the already existing key value pair both in list and map, updating the value in node will automatically update node everywhere it is used
            node.value = value;
            this.moveToHead(node);
        }
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(Node node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;  //next will be tail here
        next.prev = prev;  //next.prev is equivalent to tail.prev here
    }

    /**
     * pop the current tail.
     */
    private Node popTail(){
        Node res = tail.prev;
        this.removeNode(res);
        return res;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(Node node){
        this.removeNode(node);
        this.addNode(node);
    }
}
