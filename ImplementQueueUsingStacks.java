package com.raghvendra;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    /** Initialize your data structure here. */
    private Stack<Integer> stack;
    private Stack<Integer> bufferStack;

    public ImplementQueueUsingStacks() {
        stack = new Stack<>();
        bufferStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(bufferStack.isEmpty()) stack.push(x);
        else {
            while(!bufferStack.isEmpty()){
                int temp = bufferStack.pop();
                stack.push(temp);
            }
            stack.push(x);
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack.isEmpty() && bufferStack.isEmpty()) return -1;
        while (!stack.isEmpty()){
            int temp = stack.pop();
            bufferStack.push(temp);
        }
        return bufferStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stack.isEmpty() && bufferStack.isEmpty()) return -1;
        while(!stack.isEmpty()){
            int temp = stack.pop();
            bufferStack.push(temp);
        }
        return bufferStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack.isEmpty() && bufferStack.isEmpty()) return true;
        return false;
    }
}
