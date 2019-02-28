package com.raghvendra;

public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //If we check the conditions when rec 2 is left OR right OR above OR below of rec 1 in those cases rec1 and rec2 will not overlap
        //else they will
        if(rec1[2] <= rec2[0] ||    //rec1 is left to rec2
           rec2[2] <= rec1[0] ||    //rec1 is right to rec2
           rec1[1] >= rec2[3] ||    //rec1 is above to rec2
           rec2[1] >= rec1[3]       //rec1 is below to rec2
        ) return false;
        return true;
    }
}
