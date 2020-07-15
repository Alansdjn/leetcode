package com.wei.leetcode.problem;

import java.util.Arrays;

/**
 * @author wei wang
 * @date 2020/07/15
 */
public class P163SumClosest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {1, 6, 9, 14, 16, 70};
        int target = 81;
        int result = new P163SumClosest().new Solution().threeSumClosest(nums, target);
        System.out.print(result);
    }

    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            return threeSum(nums, target);
        }

        private int threeSum(int nums[], int target) {
            int diff = Integer.MAX_VALUE;
            int result = target;
            for (int i = 0; i < nums.length; i++) {
                int j = nums.length - 1;
                int k = i + 1;
                for (; j > k; j--) {
                    int twoSum = nums[i] + nums[j];
                    boolean flag = false;
                    while (k < j && nums[k] + twoSum < target) {
                        k++;
                        flag = true;
                    }
                    int currDiff = Integer.MAX_VALUE;
                    if (k >= j) {
                        if (flag) {
                            currDiff = Math.abs(nums[k - 1] + twoSum - target);
                            if (currDiff < diff) {
                                diff = currDiff;
                                result = nums[k - 1] + twoSum;
                            }
                        }
                        break;
                    }

                    int threeSum = nums[k] + twoSum;
                    if (threeSum == target) {
                        return target;
                    }

                    if (flag) {
                        currDiff = Math.abs(nums[k - 1] + twoSum - target);
                        if (currDiff < diff) {
                            diff = currDiff;
                            result = nums[k - 1] + twoSum;
                        }
                    }

                    currDiff = Math.abs(threeSum - target);
                    if (currDiff < diff) {
                        diff = currDiff;
                        result = threeSum;
                    }
                    if (threeSum > target) {
                        continue;
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
    }
}
