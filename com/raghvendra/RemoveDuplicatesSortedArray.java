package com.raghvendra;

public class RemoveDuplicatesSortedArray {
    public int removeDuplicates(int[] nums) {
//        Map<Integer,Integer> myMap = new TreeMap<>();
//        for(int i = 0; i <nums.length; i++){
//            if(!myMap.containsKey(nums[i])) {
//                myMap.put(nums[i],i);
//            }
//        }
//        int i = 0;
//        for(Integer key : myMap.keySet()){
//            nums[i] = key;
//            i++;
//        }
//        for(int a: nums){
//            System.out.print(a);
//        }
//        return myMap.size();
//    }
        //Second Approach
        if (nums.length == 0 || nums == null) return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
