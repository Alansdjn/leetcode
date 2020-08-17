package com.wei.leetcode.problem;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wei wang
 * @date 2020/08/16
 */
public class P78Subsets {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> r = new P78Subsets().new Solution().subsets(nums);
        r.forEach(item -> {
            item.forEach(e -> {
                System.out.print(e + " ");
            });
            System.out.println();
        });
    }

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> r = new LinkedList<>();
            r.add(new LinkedList<>());
            for (int i = 1; i <= nums.length; i++) {
                List<List<Integer>> pos = new P77Combinations().new Solution().combine(nums.length, i);
                pos.forEach(item -> {
                    List<Integer> e = new LinkedList<>();
                    item.forEach(ele -> {
                        e.add(nums[ele - 1]);
                    });
                    r.add(e);
                });

            }
            return r;
        }
    }
}
