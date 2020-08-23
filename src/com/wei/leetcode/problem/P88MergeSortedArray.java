package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/08/22
 */
public class P88MergeSortedArray {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = {0,0};
        int m = 0;
        int[] nums2 = {1,3};
        int n = 2;
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();
        new P88MergeSortedArray().new Solution().merge(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
    }

    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            --m;
            --n;
            for (int i = nums1.length - 1; i > m && i >= 0; i--) {
                if (m >= 0 && nums1[m] > nums2[n]) {
                    nums1[i] = nums1[m--];
                } else {
                    nums1[i] = nums2[n--];
                }
            }
        }
    }
}
