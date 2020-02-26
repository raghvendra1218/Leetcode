package com.raghvendra;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    /** Initialize your data structure here. */
    private Queue<Integer> queue;
    private Queue<Integer> bufferQueue;

    public ImplementStackUsingQueues() {
        queue = new LinkedList<>();
        bufferQueue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(queue.isEmpty()) queue.offer(x);
        else if (bufferQueue.isEmpty())queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return -1;
    }

    /** Get the top element. */
    public int top() {
        if(queue.isEmpty() && bufferQueue.isEmpty()) return -1;
        return -1;

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(queue.isEmpty() && bufferQueue.isEmpty()) return true;
        return false;
    }
}
