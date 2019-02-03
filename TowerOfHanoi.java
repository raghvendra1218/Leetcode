package com.raghvendra;

public class TowerOfHanoi {
    public void towerOfHanoi(int n, char fromPeg, char toPeg, char auxPeg) {
        //If only one disk make the move and return (Base case)
        if (n == 1) {
            System.out.println("Move Disk 1 from Peg "+ fromPeg+" to Peg"+ toPeg);
            return;
        }
        // Move top n-1 disks from A to B using C as auxiliary
        towerOfHanoi(n-1,fromPeg,auxPeg,toPeg);
        System.out.println("Move disk from Peg "+ fromPeg+" to Peg "+ toPeg);
        //Move n-1 disks from B to C using A as auxiliary
        towerOfHanoi(n-1,auxPeg,toPeg,fromPeg);
    }
}
