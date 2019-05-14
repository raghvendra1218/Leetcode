package com.raghvendra;

/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

*/

/**
 * Intuition : If we explore how the permutation is calculated, the way the permutations unfolds , temporal order gets the precedence
 * We need to find the decreasing sequence, becuase that is the sequence after which the permutations woudl have been exhausted for that number
 * 6215430 (part 5430 is strictly decreasing order, so we need to swap 1 with remaining plantings in increasing order i.e. - 0,3,4,5)
 * 0 is out because it is already been exhausted if we are talking in increasing sequence, because planting 0 will give lesser number, hence we
 * will choose the next bigger number in the increasing oder for plantings available , we will cho0se 3, we will swp 1 with 3
 * 6235410
 * Now we will make the sequence in increasing order after number 3, which will be the next increasing sequence and will be the next permutation
 * 6230145
 */

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >=0 && nums[i + 1] <= nums[i]){
            i--;
        }
        if(i >= 0){
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int idx){
        int i = idx, j= nums.length - 1;
        while (i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
