package com.raghvendra;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> functionStack = new Stack<>();
        int prev = 0;

        //Loop through the entire array and track the end and finish time of each function ID
        for(int i = 0; i < logs.size(); ++i){
            String[] s = logs.get(i).split(":");

            //parse the values from the string obtained
            int func = Integer.valueOf(s[0]);
            int time =  Integer.valueOf(s[2]);
            String event = s[1];

            //Check if the same function ends or there is a call to new function within that function
            if(event.contains("start")){
                if(!functionStack.isEmpty()){
                    result[functionStack.peek()] += time - prev;
                }
                functionStack.push(func);
                prev = time;
            } else {
                //This block will execute when call for a function ends, we need to remove that function from stack
                functionStack.pop();
                result[func] += time - prev + 1;
                prev = time + 1;
            }
        }
        return result;
    }
}
