package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/08/14
 */
public class P75SortColors {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new P75SortColors().new Solution().sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    class Solution {
        public void sortColors(int[] nums) {
            int begin = 0;
            int end = nums.length - 1;
            int curr = 0;
            while (curr <= end) {
                switch (nums[curr]) {
                    case 0:
                        swap(nums, begin, curr);
                        begin++;
                        curr++;
                        break;
                    case 1:
                        curr++;
                        break;
                    case 2:
                        swap(nums, curr, end);
                        end--;
                        break;
                    default:
                        //
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
