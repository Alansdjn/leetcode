package com.wei.leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wei wang
 * @date 2020/07/12
 */
public class P153Sum {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {-5, 1, -3, -1, -4, -2, 4, -1, -1};
        List<List<Integer>> result = new P153Sum().new Solution().threeSum(nums);
        result.forEach(item -> {
            item.forEach(ele -> {
                System.out.print(ele + " ");
            });
            System.out.println();
        });
    }

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length < 3) {
                return Collections.emptyList();
            }

            Arrays.sort(nums);

            if (nums[0] > 0 || nums[nums.length - 1] < 0) {
                return Collections.emptyList();
            }

            return threeSum(nums, 0, 0);
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

        private List<List<Integer>> threeSumWithHashMap(int nums[]) {
            Map<Integer, List<Integer>> valPosMap = new HashMap<>();
            for (int i = 1; i < nums.length; i++) {
                valPosMap.putIfAbsent(nums[i], new ArrayList<>());
                valPosMap.get(nums[i]).add(i);
            }

            List<List<Integer>> result = new ArrayList<>();

            for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
                int j = nums.length - 1;
                for (; j > i + 1 && nums[j] >= 0; j--) {
                    int target = -1 * (nums[i] + nums[j]);
                    if (valPosMap.containsKey(target)) {
                        final int begin = i;
                        final int end = j;
                        if (valPosMap.get(target).stream().filter(idx -> {
                            return idx > begin && idx < end;
                        }).findAny().isPresent()) {
                            result.add(assemble(nums[i], target, nums[j]));
                            while (j > i + 1 && nums[j - 1] == nums[j]) {
                                j--;
                            }
                        }
                    }
                }

                while (i < nums.length - 1 && nums[i + 1] == nums[i]) {
                    i++;
                }
            }

            return result;
        }
    }
}
