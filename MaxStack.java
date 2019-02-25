package com.raghvendra;

import java.util.Stack;

public class MaxStack {

    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private Stack<Integer> maxStack;

    public MaxStack() {
        this.stack = new Stack<>();
        this.maxStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(maxStack.isEmpty() || x >= maxStack.peek()){
            maxStack.push(x);
        }
    }

    public int pop() {
        if(stack.peek() == maxStack.peek()) maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
            return maxStack.peek();
    }

    public int popMax() {
        return -1;
    }
}
