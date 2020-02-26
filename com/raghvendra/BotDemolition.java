package com.raghvendra;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BotDemolition {

    private class Cell{
        int row;
        int col;
        int distance;
        Cell(int x, int y, int z){
            row = x;
            col = y;
            distance = z;
        }
    }


    public int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot){
        Cell startPoint = new Cell(0,0,0);
        boolean visited[][] = new boolean[numRows][numColumns];
        for(int row = 0; row < numRows; row++){
            for(int col = 0; col < numColumns; col++){
                if(lot.get(row).get(col) == 0){
                    visited[row][col] = true;
                } else {
                    visited[row][col] = false;
                }
                //You can check the co-ordinates for passed source row and col and set the point of start while traversal
                //Basically overwrite the startPoint row and col values which are most likely be sent as apart of argument
            }
        }
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(startPoint);
        visited[startPoint.row][startPoint.col] = true;
        while(!queue.isEmpty()){
            Cell temp =  queue.poll();
            if(lot.get(temp.row).get(temp.col) == 9){
                return temp.distance;
            }
            //Move Up
            if(temp.row - 1 >= 0 && visited[temp.row - 1][temp.col] == false){
                queue.offer(new Cell(temp.row - 1, temp.col, temp.distance + 1));
                visited[temp.row - 1][temp.col] = true;
            }

            //Move Down
            if(temp.row + 1 < numRows && visited[temp.row + 1][temp.col] == false){
                queue.offer(new Cell(temp.row + 1, temp.col, temp.distance + 1));
                visited[temp.row + 1][temp.col] = true;
            }

            //Move Left
            if(temp.col - 1 >= 0 && visited[temp.row][temp.col - 1] == false){
                queue.offer(new Cell(temp.row, temp.col - 1, temp.distance + 1));
                visited[temp.row][temp.col - 1] = true;
            }

            //Move Right
            if(temp.col + 1 < numColumns && visited[temp.row][temp.col + 1] == false){
                queue.offer(new Cell(temp.row , temp.col + 1, temp.distance + 1));
                visited[temp.row][temp.col + 1] = true;
            }
        }
        return -1;
    }
}
