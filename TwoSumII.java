package com.raghvendra;

public class TwoSumII {
    /*
        Approach 1: Using HashMap
     */
//    public int[] twoSum(int[] numbers, int target) {  //2,7,11,15 , target : 9
//        Map<Integer,Integer> myMap =  new HashMap<>();
//        int[] result = new int[2];
//        for(int i = 0; i < numbers.length;i++){
//            result[1] = i;
//            if(myMap.containsKey(target - numbers[i])){
//                result[0] = myMap.get(target - numbers[i]);
//                result[0] = result[0]+1;
//                result[1] = result[1]+1;
//                return result;
//            } else {
//                myMap.put(numbers[i],i);
//            }
//        }
//        return result;
//    }

    /*
        Second Approach : Two pointer
     */

    public int[] twoSum(int[] numbers, int target) {  //2,7,11,15 , target : 9
        int  i = 0, j = numbers.length -1;;
        int[] result = new int[2];
        while(numbers[i] + numbers[j] != target){
            while(numbers[i] + numbers[j] < target){
                i++;
            }
            while(numbers[i] + numbers[j] > target){
                j--;
            }
        }
        result[0] = i+1;
        result[1] = j+1;
        return result;
    }
}
