package com.wei.leetcode.problem;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * nums1 = [1, 3] nums2 = [2]
 * 
 * The median is 2.0 Example 2:
 * 
 * nums1 = [1, 2] nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * @author wei wang
 * @date 2020/03/20
 */
public class MedianofTwoSortedArrays {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int total = nums1.length + nums2.length;
            int position = total / 2;
            boolean odd = (total % 2 == 1);
            double median = 0;

            int max = 0, min = 0;

            if (odd) {
                // nums1 < nums2

                if (nums1[nums1.length - 1] < nums2[0]) {
                    if (nums1.length < position) {
                        median = nums2[position - nums1.length - 1];
                    } else {
                        median = nums2[position - 1];
                    }
                } else if (nums1[0] > nums2[nums2.length - 1]) {
                    if (nums2.length < position) {
                        median = nums1[position - nums2.length - 1];
                    } else {
                        median = nums1[position - 1];
                    }
                } else {
                    int n1Begin = 0;
                    int n1End = nums1.length - 1;
                    int n1Mid = (n1Begin + n1End) / 2;
                    int n1MidVal = getMiddleValDefaultLow(nums1, n1Begin, n1End);

                    int n2Begin = 0;
                    int n2End = nums2.length;
                    int n2Mid = (n2Begin + n2End) / 2;
                    int n2MidVal = getMiddleValDefaultLow(nums2, n2Begin, n2End);

                    max = Math.max(n1MidVal, n2MidVal);
                    min = Math.min(n1MidVal, n2MidVal);

                    while (true) {
                        // int tmp
                        if (n1MidVal > n2MidVal) {
                            n1End  =  n1Mid;
                        } else if (n1MidVal > n2MidVal) {

                        } else {
                            median = n1MidVal;
                            break;
                        }
                    }
                }
            }
            return 0;

        }

        public int getMiddleValDefaultLow(int[] nums, int begin, int end) {
            int middlePosition = (begin + end) / 2;
            middlePosition = (begin + end) % 2 == 0 ? middlePosition + 1 : middlePosition;

            return nums[middlePosition];
        }
    }

}
