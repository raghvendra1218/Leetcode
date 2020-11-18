package com.raghvendra;

public class MirrorReflection {
    public int mirrorReflection(int p, int q) {

        while(isEven(p) && isEven(q)) {
            p = p >> 1; // p = p / 2;
            q >>= 1; // q = q / 2;
        }

        // we have already removed the case where both p and q can be even below this line
        // case 1: when p is even, q had to be odd
        if(isEven(p)) return 2;

        // now, below this line, p is odd fro sure, and q can be either odd or even
        if(!isEven(q)) { // q is odd
            return 1;
        }

        // p is odd and q is even
        return 0;
    }

    private boolean isEven(int x) {
        // LSB of x and 1 gets AND'ed
        return (x & 1) == 0;
    }
}
