package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/07/30
 */
public class P55JumpGame {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new P55JumpGame().new Solution().canJump(nums));

    }

    class Solution {
        public boolean canJump(int[] nums) {
            if (nums.length <= 1) {
                return true;
            }
            if (nums.length == 2) {
                return nums[0] > 0;
            }

            nums[nums.length - 1] = 1;
            int falseLength = 0;
            for (int i = nums.length - 2; i >= 0; i--) {
                int curr = nums[i];
                nums[i] = 0;
                for (int j = 1 + falseLength; i + j < nums.length && j <= curr; j++) {
                    if (nums[i + j] == 1) {
                        nums[i] = 1;
                        break;
                    }
                }

                falseLength = (nums[i] == 1) ? 0 : falseLength + 1;
            }
            return nums[0] == 1;
        }
    }
}
