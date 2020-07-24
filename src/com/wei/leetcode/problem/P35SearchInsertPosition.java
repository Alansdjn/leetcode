package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/07/24
 */
public class P35SearchInsertPosition {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1,3,5, 6};
        int target = 5;
        System.out.println(new P35SearchInsertPosition().new Solution().searchInsert(nums, target));

    }

    class Solution {
        public int searchInsert(int[] nums, int target) {
            if (nums.length == 0 || nums[0] >= target) {
                return 0;
            }
            if (nums[nums.length - 1] <= target) {
                return nums[nums.length - 1] == target ? nums.length - 1 : nums.length;
            }
            
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= target) {
                    return i;
                }
            }
            
            return nums.length;

//            int begin = 0;
//            int end = nums.length - 1;
//
//            while (end > begin) {
//                if (end - begin == 1) {
//                    if (nums[end] == target) {
//                        return end;
//                    }
//                    if (nums[begin] == target) {
//                        return begin;
//                    }
//                    if (nums[begin] < target && target < nums[end]) {
//                        return begin + 1;
//                    }
//                }
//                int middle = (end - begin) / 2;
//                if (nums[middle] == target) {
//                    return middle;
//                }
//                if (target < nums[middle]) {
//                    end = middle;
//                }
//                if (nums[middle] < target) {
//                    begin = middle;
//                }
//            }
//
//            return begin + 1;
        }
    }
}
