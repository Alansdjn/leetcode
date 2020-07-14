package com.wei.leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author wei wang
 * @date 2020/07/14
 */
public class P184Sum {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {-1, -5, -5, -3, 2, 5, 0, 4};
        int target = -7;
        List<List<Integer>> result = new P184Sum().new Solution().fourSum(nums, target);
        result.forEach(item -> {
            item.forEach(ele -> {
                System.out.print(ele + " ");
            });
            System.out.println();
        });
    }

    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            if (nums.length < 4) {
                return Collections.emptyList();
            }

            Arrays.sort(nums);

            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length - 3; i++) {
                List<List<Integer>> threeSumResult = threeSum(nums, i + 1, target - nums[i]);
                final int curr = nums[i];
                threeSumResult.forEach(item -> {
                    item.add(0, curr);
                });
                result.addAll(threeSumResult);

                i = skipEqElement(nums, i);
            }

            return result;
        }

        private List<List<Integer>> threeSum(int nums[], int begin, int target) {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = begin; i < nums.length; i++) {
                int j = nums.length - 1;
                int k = i + 1;
                int stop_pos = i + 1;
                for (; j > k; j--) {
                    int twoSum = nums[i] + nums[j];
                    while (k < j && nums[k] + twoSum < target) {
                        k++;
                    }
                    if (k >= j) {
                        break;
                    }

                    int threeSum = nums[k] + twoSum;
                    if (threeSum > target) {
                        continue;
                    }

                    if (threeSum == target) {
                        result.add(assemble(nums[i], nums[k], nums[j]));
                        while (j > stop_pos && nums[j - 1] == nums[j]) {
                            j--;
                        }
                    }
                }

                i = skipEqElement(nums, i);
            }

            return result;
        }

        private int skipEqElement(int[] nums, int i) {
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
            return i;
        }

        private List<Integer> assemble(int... a) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < a.length; i++) {
                tmp.add(a[i]);
            }
            return tmp;
        }
    }

}
