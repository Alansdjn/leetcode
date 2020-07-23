package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/07/22
 */
public class P33SearchinRotatedSortedArray {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {4};
        int target = 4;
        System.out.println(new P33SearchinRotatedSortedArray().new Solution().search(nums, target));
    }

    class Solution {
        public int search(int[] nums, int target) {
            if (nums.length == 0) {
                return -1;
            }
            if (nums.length == 1) {
                return nums[0] == target ? 0 : -1;
            }

            int middle = nums.length / 2;
            if (nums[middle] == target) {
                return middle;
            }

            int r = search(nums, 0, middle - 1, target);
            if (r != -1) {
                return r;
            }

            return search(nums, middle + 1, nums.length - 1, target);
        }

        public int search(int[] nums, int begin, int end, int target) {
            if (end < begin) {
                return -1;
            }
            if (end == begin) {
                return nums[begin] == target ? begin : -1;
            }

            int middle = (begin + end) / 2;

            if (nums[middle] == target) {
                return middle;
            }

            if (middle != begin) {
                if (nums[begin] < nums[middle]) {
                    if (nums[begin] <= target && target <= nums[middle]) {
                        return search(nums, begin, middle - 1, target);
                    }
                } else {
                    if (nums[begin] <= target || target <= nums[middle]) {
                        return search(nums, begin, middle - 1, target);
                    }
                }
            }

            if (nums[end] > nums[middle]) {
                if (nums[middle] <= target && target <= nums[end]) {
                    return search(nums, middle + 1, end, target);
                }
            } else {
                if (nums[middle] <= target || target <= nums[end]) {
                    return search(nums, middle + 1, end, target);
                }
            }

            return -1;
        }
    }
}
