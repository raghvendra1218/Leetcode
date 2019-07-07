package com.raghvendra;

import java.util.ArrayList;
import java.util.List;

public class FindMissingInArrayWithDuplicates {

    public List<Integer> findMissing(int[] nums){
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; ++i){
            //Normalising the array's  with  loop (becoz array's index starts with 0), and absolute ensures the negative index does not throws index out of bound exception
            int idx = Math.abs(nums[i]) - 1;

            if(nums[idx] > 0){
                //Replacing the value for the already present value with the -ve indexes, to ensure or mark them as present
                nums[idx] = -nums[idx];
            }
        }
        //Traverse through the loop to find the missing numbers , those numbers will be added where the value at the index is positive
        for(int i = 0; i< nums.length; ++i){
            if(nums[i] > 0){
                result.add(i+1);
            }
        }

        System.out.println("Missing values: "+ result.toString());
        return result;
    }
}
