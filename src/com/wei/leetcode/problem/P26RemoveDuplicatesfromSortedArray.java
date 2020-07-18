package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/07/18
 */
public class P26RemoveDuplicatesfromSortedArray {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {};

        System.out.println(new P26RemoveDuplicatesfromSortedArray().new Solution().removeDuplicates(nums));

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length <= 1) {
                return nums.length;
            }

            int curr = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[curr] != nums[i]) {
                    curr++;
                    nums[curr] = nums[i];
                }
            }
            return curr + 1;
        }
    }
}
