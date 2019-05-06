package com.raghvendra;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> myStack = new Stack<>();
        for(int i = 0; i < asteroids.length; ++i){
            collision : {
                int num = asteroids[i];
                while(!myStack.isEmpty() && num < 0 && myStack.peek() > 0){
                    if(Math.abs(num) > myStack.peek()){
                        myStack.pop();
                        continue;
                    } else if(myStack.peek() == -num){  //condition when both the ast are of same weight but moving in opp drxn, we need to blast both
                        myStack.pop();
                    }
                    //it means that stack's top contains element, which is greater than Math.abs(num), in this case we need to blast num,
                    //so in this case we will take the next element in the asteroids array, without pushing num
                    break collision;
                }
                myStack.push(num);
            }
        }
        int[] result =  new int[myStack.size()];
        int i = myStack.size() - 1;
        while (!myStack.isEmpty()){
            result[i] = myStack.pop();
            i--;
        }
        return result;
    }
}
