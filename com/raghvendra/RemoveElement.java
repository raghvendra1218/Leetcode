/**
 Given an array nums and a value val, remove all instances of that value in-place and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 Example 1:

 Given nums = [3,2,2,3], val = 3,

 Your function should return length = 2, with the first two elements of nums being 2.

 It doesn't matter what you leave beyond the returned length.
 Example 2:

 Given nums = [0,1,2,2,3,0,4,2], val = 2,

 Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

 Note that the order of those five elements can be arbitrary.

 It doesn't matter what values are set beyond the returned length.
 Clarification:

 Confused why the returned value is an integer but your answer is an array?

 Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

 Internally you can think of this:

 // nums is passed in by reference. (i.e., without making a copy)
 int len = removeElement(nums, val);

 // any modification to nums in your function would be known by the caller.
 // using the length returned by your function, it prints the first len elements.
 for (int i = 0; i < len; i++) {
 print(nums[i]);
 */

/**
 * Approach 1 -  Two pointers, whenever you encounter the target value don't do anything, but when you find a value which is not equal to the target value. you place it at the slow index
 * and increment the slow index by 1
 */
//public class RemoveElement {
//    public int removeElement(int[] nums, int val) {
//        int slow  = 0;
//        for(int fast = 0; fast < nums.length; ++fast) {
//            if(nums[fast] != val) {
//                nums[slow] = nums[fast];
//            }
//        }
//        return slow;
//    }
//}

/**
 * Approach 2 - Find the number which match the target value and put them at the end. And decrease the size of the loop by 1 for every encounter
 *              Return the n. n being initialized to the length of the nums
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int start = 0;
        int n = nums.length;
        while(start < n) {
            //swap the current element out with the last element and dispose the last one
            if(nums[start] == val) {
                nums[start] = nums[n - 1];
                //reduce the length by 1
                n--;
            } else {
                start++;
            }
        }
        return n;
    }
}