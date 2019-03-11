package com.raghvendra;

public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        /**
         * Approach 1: Using Toggling Approach, the operation n = n&(n-1) will always toggle the right most bit.
         */
//        int count  = 0;
//        while(n != 0){
//         count++;
//         n = n&(n-1);
//        }
//        return count;

        /**
         * Using Bitwise Operator
         * Intuition : if we And the number by 1, we will come to know if the least significant digit is set or not
         * we can right shift the number by 1 after each iteration, keep the track if the least significant digit is one or not
         * NOT FOR JAVA - Note that in some languages such as Java, there is no unsigned integer type.
         * In this case, the input will be given as signed integer type
         */
//        int count  = 0;
//        while( n!=0 ){
//            if((n&1) == 1){
//             count++;
//            }
//           n = n>>1;
//        }
//        return count;

        /**
         * Using modulo operator , instead of dvising by 10 , we will divide by 2
         */

        int count  = 0;
        while(n != 0){
            if(n%2 != 0) {
                count++;
            }
            n = n/2;
        }
        return count;
    }
}
