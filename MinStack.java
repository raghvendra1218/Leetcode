package com.raghvendra;

import java.util.Stack;

public class MinStack {
    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private  Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        this.stack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop() {
        int poppedValue = 0;
        if(!this.stack.isEmpty()) {
            poppedValue = this.stack.pop();
            if(poppedValue == minStack.peek()){
                minStack.pop();
            }
        }
    }

    public int top() {
        if(!this.stack.isEmpty()) return this.stack.peek();
        else return -1;
    }

    public int getMin() {
        if(!this.minStack.isEmpty())return minStack.peek();
        else return -1;
    }
}
