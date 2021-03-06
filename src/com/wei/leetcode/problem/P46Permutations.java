package com.wei.leetcode.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wei wang
 * @date 2020/08/01
 */
public class P46Permutations {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = null;
        for (int i = 1; i < 10; i++) {
            nums = new int[i];
            for (int j = 0; j < i; j++) {
                nums[j] = j + 1;
            }
            List<List<Integer>> r = new P46Permutations().new Solution().permute(nums);
            System.out.println(i + " : " + N(i) + " : " + r.size());
            // r.forEach(item -> {
            // System.out.println(item);
            // });
        }
    }

    private static int N(int i) {
        int r = 1;
        for (; i > 0; i--) {
            r *= i;
        }
        return r;
    }

    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                swap(nums, 0, i);
                result.addAll(generate(nums, 1));
                swap(nums, i, 0);
            }
            return result;
        }

        private void swap(int[] nums, int from, int to) {
            int tmp = nums[from];
            nums[from] = nums[to];
            nums[to] = tmp;
        }

        private List<List<Integer>> generate(int[] nums, int begin) {
            List<List<Integer>> result = new ArrayList<>();
            if (begin == nums.length) {
                List<Integer> r = new LinkedList<>();
                for (int i = 0; i < nums.length; i++) {
                    r.add(nums[i]);
                }
                result.add(r);
                return result;
            }

            for (int i = begin; i < nums.length; i++) {
                swap(nums, begin, i);
                result.addAll(generate(nums, begin + 1));
                swap(nums, i, begin);
            }
            return result;
        }
    }
}
