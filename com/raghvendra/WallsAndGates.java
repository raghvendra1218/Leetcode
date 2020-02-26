package com.raghvendra;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    /**
     * Approach 1 : We can find all the rooms. For each room BFS until the gate with minimum path is found. Time Complexity : O(x * m * n) , x: number of gates.
     * Approach 2: We can find all the gates. For each Gate BFS for all the rooms. Time Complexity : O(m * n).
     * Approach 3: DFS will not be a good option, always use BFS when we have to just find if path exits or not, use DFS when find all possible paths
     */

    //define a class cell which will store the state for each cell in the matrix
    private class Cell{
        int row;
        int col;
        Cell(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public void wallsAndGates(int[][] rooms) {
        //define a matrix with pre-defined possiblity for movement from each cell
        int[][] moves = new int[][]{{1, 0},{-1, 0},{0, 1},{0, -1}};
        Queue<Cell> gates = new LinkedList<>();

        //traverse through the rooms matrix and store the number of gates in a queue
        for(int row = 0; row < rooms.length; row++){
            for(int col = 0; col < rooms[0].length; col++){
                if(rooms[row][col] == 0){
                    gates.offer(new Cell(row, col));
                }
            }
        }

        //For each gate stored in the Queue we need to check how far is each room is ?
        //Following the only direction as per mentioned in the move (it will coem out level by level,
        //since we can go one step either L/R/U/D from that cell, so naturally it will cover the peripherals around each Cell.
        //This justifies that we are Traversing the graph via BFS, also the DS used Queue ensures the BFS traversal,
        //Had it been the Stack instead of queue it would have been DFS irrespective of moves defined, so basically use of DS (stack/queue) is player here
        while (!gates.isEmpty()){
            Cell currentCell = gates.poll();
            int x = currentCell.row;
            int y = currentCell.col;
            //Assign the number of steps for each cell following the moves matrix defined above
            //moves matrix has only 2 cols so no need of two loops
            for(int i = 0; i < moves.length; i++){
                calculateSteps(x + moves[i][0], y + moves[i][1], rooms, gates, rooms[x][y] + 1);
            }
        }
    }

    private void calculateSteps(int row, int col, int[][] rooms, Queue<Cell> gates, int steps){
        if( row < 0 || row >= rooms.length ||
            col < 0 || col >= rooms[0].length ||
            rooms[row][col] == -1 ||
            rooms[row][col] != Integer.MAX_VALUE
          ){
            return;
        }

        rooms[row][col] = steps;
        gates.add(new Cell(row,col));
    }
}
