package com.raghvendra;

/*
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */

public class ReverseInteger {
    int index = 0;
    public int reverse(int x) {
//        int ans = 0;
//        int rem = 0;
//
//        while(x != 0){
//            rem = x%10;
//            if(ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && rem > 7)){
//                return 0;
//            }
//            if(ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE/10 && rem < -8 )){
//                return 0;
//            }
//            ans = ans * 10 + rem;
//            x = x/10;
//        }
//        return ans;
        if(x < 10){
//            index++;
            return x;
        }
//        ans = 10 * reverse(x/10) + ;
        int y = reverse(x/10);
        index++;
        return ((int)(Math.pow(10,index))*(x%10)+y);
    }
}
