package com.raghvendra;

import java.util.HashMap;
import java.util.Map;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {  //2,7,11,15 , target : 9
        Map<Integer,Integer> myMap =  new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < numbers.length;i++){
            result[1] = i;
            if(myMap.containsKey(target - numbers[i])){
                result[0] = myMap.get(target - numbers[i]);
                return result;
            } else {
                myMap.put(numbers[i],i);
            }
        }
        return result;
    }
}
