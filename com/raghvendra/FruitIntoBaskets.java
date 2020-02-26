package com.raghvendra;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
//        int max = 0, count = 0;
//        for (int i = 0, first = 0, second = -1; i < tree.length; i++) {
//            count++;
//            if (tree[i] == tree[first]) {
//                first = i;
//            } else if (second == -1 || tree[i] == tree[second]) {
//                second = i;
//            } else {
//                max = Math.max(count - 1, max);
//                count = Math.abs(first - second) + 1;
//                first = i - 1;
//                second = i;
//            }
//        }
//        return Math.max(count, max);
        Map<Integer,Integer> myMap = new HashMap<>();
        int index = 0;
        int max = 0;
        int tempIndex = -1;
        int newMax = 0;
        while(index < tree.length){
            if(myMap.size() < 2){
                if(myMap.containsKey(tree[index])){
                    myMap.put(tree[index], myMap.get(tree[index])+1);
                } else {
                    if(myMap.size() == 1){
                        tempIndex = index;
                    }
                    myMap.put(tree[index],1);
                }
                index++;
            } else if (myMap.size() == 2){
                if(myMap.containsKey(tree[index])){
                    myMap.put(tree[index], myMap.get(tree[index])+1);
                    index++;
                } else {
                    max = returnMax(myMap,newMax,max);
                    index = tempIndex;
                    myMap = new HashMap<>();
                }
            }
        }
        max = returnMax(myMap,newMax,max);
        return max;
    }

    private int returnMax(Map<Integer,Integer>myMap, int newMax, int max){
        newMax = 0;
        for(Map.Entry<Integer,Integer> entry : myMap.entrySet()){
            newMax += entry.getValue();

        }
        if(newMax > max){
            max = newMax;
        }
        return max;
    }
}
