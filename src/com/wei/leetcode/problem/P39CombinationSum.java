package com.wei.leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wei wang
 * @date 2020/07/24
 */
public class P39CombinationSum {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6,7};
        int target = 2;
        System.out.println(new P39CombinationSum().new Solution().combinationSum(candidates, target));
    }

    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {

            return combinationSum(null, candidates, 0, target);
        }

        public List<List<Integer>> combinationSum(List<Integer> canditatList, int[] candidates, int idx, int target) {
            if (canditatList == null) {
                canditatList = new ArrayList<>();
            }

            if (target == 0) {
                List<Integer> tmp = new ArrayList<>();
                for (Integer item : canditatList) {
                    tmp.add(item);
                }
                return Arrays.asList(tmp);
            }

            List<List<Integer>> r = new ArrayList<>();
            for (int i = idx; i < candidates.length; i++) {
                int newTarget = target - candidates[i];
                if (newTarget < 0) {
                    continue;
                }

                canditatList.add(candidates[i]);
                List<List<Integer>> tmp = combinationSum(canditatList, candidates, i, newTarget);
                if (!tmp.isEmpty()) {
                    r.addAll(tmp);
                }
                canditatList.remove(canditatList.size() - 1);
            }

            return r;
        }
    }
}
