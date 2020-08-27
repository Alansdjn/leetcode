package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/08/26
 */
public class P96UniqueBinarySearchTrees {

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 1; i < 19; i++) {
            System.out.println(i + " : " + new P96UniqueBinarySearchTrees().new Solution().numTrees(i));
        }

    }

    class Solution {
        public int numTrees(int n) {
            if (n == 1) {
                return 1;
            }
            int[] cnts = new int[n + 1];
            cnts[0] = 1;
            cnts[1] = 1;
            for (int i = 3; i <= n; i++) {
                int cnt = 0;
                for (int root = 1; root <= i; root++) {
                    int val = cnts[root - 1] * cnts[i - root];
                    cnt += val;
                }
                cnts[i] = cnt;
            }

            return cnts[n];
        }
    }
}
