package com.raghvendra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfThreeSortedArrays {
    /**
     * Approach 1: Check for each values of arr1, in arr2 and arr3, if found in all given arrays, add it in result.
     * Use Binary search to search the elements in arr2 and arr3
     */
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();

        for (int j : arr1) {
            // check for the value in arr1, find in the arr2
            int val = binarySearch(arr2, j);
            if (val >= 0) {
                // check if value exists in the arr2, if exists, find in the arr3
                val = binarySearch(arr3, j);
                if (val >= 0) {
                    // check if value exists in the arr3, if exists, add in the result list
                    result.add(j);
                }
            }
        }

        return result;
    }

    // Binary search program
    private int binarySearch(int[] arr, int x) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if(arr[mid] == x) return mid;
            else if(arr[mid] < x){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Approach 1: Create map and store the frequency of the elements in a map,
     * add the keys in the result list where value is equal to 3.
     */
    public List<Integer> arraysIntersectionII(int[] arr1, int[] arr2, int[] arr3) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int idx1, idx2, idx3;
        idx1 = idx2 = idx3 = 0;

        while(idx1 < arr1.length && idx2 < arr2.length && idx3 < arr3.length) {
            map.put(arr1[idx1], map.getOrDefault(arr1[idx1], 0) + 1);
            map.put(arr2[idx2], map.getOrDefault(arr2[idx2], 0) + 1);
            map.put(arr3[idx3], map.getOrDefault(arr3[idx3], 0) + 1);
            idx1++;
            idx2++;
            idx3++;
        }

        while (idx1 < arr1.length) {
            map.put(arr1[idx1], map.getOrDefault(arr1[idx1], 0) + 1);
            idx1++;
        }
        while (idx2 < arr2.length) {
            map.put(arr2[idx2], map.getOrDefault(arr2[idx2], 0) + 1);
            idx2++;
        }
        while (idx3 < arr3.length) {
            map.put(arr3[idx3], map.getOrDefault(arr3[idx3], 0) + 1);
            idx3++;
        }

        for(Map.Entry<Integer, Integer> element : map.entrySet()) {
            int val = element.getValue();
            int key = element.getKey();
            if(val == 3) {
                result.add(key);
            }
        }

        return result;
    }
}
