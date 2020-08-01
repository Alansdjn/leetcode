package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/07/30
 */
public class P45JumpGameII {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2, 3, 0, 1, 4};
        System.out.println(new P45JumpGameII().new Solution().jump(nums));

    }

    class Solution {
        public int jump(int[] nums) {
            if (nums.length <= 1) {
                return 0;
            }
            if (nums.length == 2) {
                return 1;
            }

            nums[nums.length - 1] = 0;
            int falseLength = 0;
            for (int i = nums.length - 2; i >= 0; i--) {
                int min = nums.length;
                for (int j = 1 + falseLength; i + j < nums.length && j <= nums[i]; j++) {
                    int pos = i + j;
                    if (nums[pos] + 1 < min) {
                        min = nums[pos] + 1;
                    }
                }
                nums[i] = min;
                falseLength = (min == nums.length) ? falseLength + 1 : 0;
            }

            return nums[0];
        }
    }
}
