package com.raghvendra;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int open = 0;
        int close = 0;
        generateParenthesis(n, open, close, result, "");
        return result;
    }

    private void generateParenthesis( int n, int open, int close, List<String> result, String s){
        //Base case
        if(open == n && close == n){
            result.add(s);
        }

        //Recursive Cases

        //We know that neither open or close should exceed the given 'n'
        if(open > n || close > n){
            return;
        }

        //We know that open cannot exceed the given number 'n'
        if(open < n){
            generateParenthesis(n,open + 1, close, result, s+'(');
        }

        //We know that there should be at least one open before putting a close bracket to make a valid permutation
        if(close < open){
            generateParenthesis(n,open,close + 1,result,s+')');
        }
    }
}
