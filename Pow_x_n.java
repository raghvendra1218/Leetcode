package com.raghvendra;

public class Pow_x_n {
    /**
     * Approach 1: Using simple for loop, does not work for -ve powers
     * @param x
     * @param n
     * @return
     */
/*    public double myPow(double x, int n) {
        int result = 1;
        for(int i = 1; i<=n; ++i){
            result *= x;
        }
        return result;
    }*/

    /**
     * Approach 2: Using log(n) Divide and Conquer
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        //Base case
        if(n == 0) return 1;
        else if(n == 1) return x;
        else if(n < 0) return 1/(x * myPow(x, -(n + 1)));
        else {
            double temp = myPow(x, n/2);  //becoz x^n = temp * temp
            if(n % 2 == 0){
                return temp * temp;
            } else {
                return temp * x * temp;
            }
        }

    }
}
