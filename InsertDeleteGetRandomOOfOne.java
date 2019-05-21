package com.raghvendra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertDeleteGetRandomOOfOne {

     private List<Integer> list;
     private Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public InsertDeleteGetRandomOOfOne() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            this.list.add(val);
            int idx = this.list.size() - 1;
            this.map.put(val, idx);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int idx = map.get(val);
            //swap the current value with the value at the end of the list
//            int temp = list.get(idx);
            int temp = val;
            int ListLastIndexVal = list.get(list.size() - 1);
            list.set(idx, ListLastIndexVal);
            list.set(list.size() - 1, temp);

            //update the map value with new index as the end of the list
            map.put(val, list.size() - 1);
            map.put(ListLastIndexVal, idx);

            //Remove values both from map and list
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int min = 0;
        int max = list.size() - 1;
        int rand = (int)(Math.random() * ((max - min) + 1) + min);
        System.out.println("Random : "+ rand);
        return list.get(rand);
    }
}
