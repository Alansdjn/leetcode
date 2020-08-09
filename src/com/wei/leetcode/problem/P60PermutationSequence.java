package com.wei.leetcode.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wei wang
 * @date 2020/08/09
 */
public class P60PermutationSequence {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String r = new P60PermutationSequence().new Solution().getPermutation(3, 3);
        System.out.println(r);

    }

    class Solution {

        public String getPermutation(int n, int k) {
            int[] cnt = new int[n];
            cnt[0] = 1;
            for (int i = 1; i < n; i++) {
                cnt[i] = (i + 1) * cnt[i - 1];
            }
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = i + 1;
            }

            //int oriK = k;
            for (int i = n - 1; i >= 0 && k > 0; i--) {
                if (cnt[i] > k) {
                    continue;
                }

                int a = k / cnt[i] + (k % cnt[i] == 0 ? 0 : 1);
                k = k - (a - 1) * cnt[i];
                if (a > 1) {
                    shift(nums, n - 1 - i - 2 + a, n - 1 - i - 1);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(nums[j]);
            }
            
            return sb.toString();
//
//            for (int i = 0; i < n; i++) {
//                nums[i] = i + 1;
//            }
//            List<List<Integer>> r = permute(nums, oriK);
//            StringBuilder sb = new StringBuilder();
//            r.forEach(item -> {
//                item.forEach(e -> {
//                    sb.append(e);
//                });
//            });
//            return sb.toString();
        }

        // ================================================

        public String getPermutation_1(int n, int k) {
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = i + 1;
            }
            List<List<Integer>> r = permute(nums, k);
            StringBuilder sb = new StringBuilder();
            r.forEach(item -> {
                item.forEach(e -> {
                    sb.append(e);
                });
            });
            return sb.toString();
        }

        public List<List<Integer>> permute(int[] nums, int k) {
            return generate(nums, 0, k);
        }

        private List<List<Integer>> generate(int[] nums, int begin, int k) {
            List<List<Integer>> result = new ArrayList<>();
            if (begin == nums.length) {
                if (inc() == k) {
                    List<Integer> r = new LinkedList<>();
                    for (int i = 0; i < nums.length; i++) {
                        r.add(nums[i]);
                    }
                    result.add(r);
                }
                return result;
            }

            for (int i = begin; i < nums.length; i++) {
                shift(nums, i, begin);
                result.addAll(generate(nums, begin + 1, k));
                shift(nums, begin, i);
            }
            return result;
        }

        int cnt = 0;

        private int inc() {
            cnt += 1;
            return cnt;
        }

        private void shift(int[] nums, int from, int to) {
            if (from == to) {
                return;
            }

            int tmp = nums[from];
            if (to > from) {
                while (from < to) {
                    nums[from++] = nums[from];
                }
            } else {
                while (from > to) {
                    nums[from--] = nums[from];
                }
            }
            nums[to] = tmp;
        }

    }

}
