package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/07/18
 */
public class P27RemoveElement {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int r = new P27RemoveElement().new Solution().removeElement(nums, val);
        System.out.println(r);
        for (int i = 0; i < r; i++) {
            System.out.print(nums[i] + " ");
        }

    }

    class Solution {
        public int removeElement(int[] nums, int val) {
            int i = 0;
            int last = nums.length - 1;
            while (i <= last) {
                if (nums[i] == val) {
                    while (last > i && nums[last] == val) {
                        last--;
                    }
                    if (last <= i) {
                        break;
                    }
                    nums[i] = nums[last];
                    nums[last] = val;
                }
                i++;
            }
            return i;
        }
    }
}
