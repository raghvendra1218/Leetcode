package com.raghvendra;

import java.util.HashSet;
import java.util.Set;

public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        set.add(distanceBetweenTwoPoints(p1, p2));
        set.add(distanceBetweenTwoPoints(p1, p3));
        set.add(distanceBetweenTwoPoints(p1, p4));
        set.add(distanceBetweenTwoPoints(p2, p3));
        set.add(distanceBetweenTwoPoints(p3, p4));

        // point should not overlap (visualize as right angled triangle, avoid this use-case, we don't want to include right angled triangle)
        // and in set we must not have more than two values of distance one is diagonal and another is side 'a' of square
        return (!set.contains(0) && set.size() == 2);
    }

    private int distanceBetweenTwoPoints(int[]a, int[]b) {
        return ((a[0] - b[0])*(a[0] - b[0]) + (a[1] - b[1])*(a[1] - b[1])); //pythagoras theorem
    }
}
