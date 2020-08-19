package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/08/19
 */
public class P80RemoveDuplicatesfromSortedArrayII {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // int[] nums = {1, 1, 1, 2, 2, 3};
        // int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int[] nums = {2,2,2};
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        System.out.println(new P80RemoveDuplicatesfromSortedArrayII().new Solution().removeDuplicates(nums));
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    class Solution {
        public int removeDuplicates(int[] nums) {

            if (nums.length < 2) {
                return nums.length;
            }

            int cnt = 1;
            int curr = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] == nums[i]) {
                    cnt++;
                    continue;
                }

                cnt = (cnt > 2) ? 2 : cnt;
                while (cnt > 0) {
                    cnt--;
                    nums[curr++] = nums[i - 1];
                }

                cnt++;
            }

            cnt = (cnt > 2) ? 2 : cnt;
            while (cnt > 0) {
                cnt--;
                nums[curr++] = nums[nums.length - 1];
            }

            return curr;
        }
    }

}
