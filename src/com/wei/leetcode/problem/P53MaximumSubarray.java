package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/08/06
 */
public class P53MaximumSubarray {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new P53MaximumSubarray().new Solution().maxSubArray(nums));

    }

    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            int prev = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int curr = nums[i];
                if (prev > 0) {
                    curr += prev;
                }
                if (curr > max) {
                    max = curr;
                }
                prev = curr;
            }

            return max;
        }
    }
}
