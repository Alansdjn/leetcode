package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/08/09
 */
public class P62UniquePaths {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Long begin = System.currentTimeMillis();
        System.out.println(new P62UniquePaths().new Solution().uniquePaths(20,10));
        // System.out.println(System.currentTimeMillis() - begin);
        // begin = System.currentTimeMillis();
        System.out.println(new P62UniquePaths().new Solution().uniquePaths1(20,10));
        // System.out.println(System.currentTimeMillis() - begin);
    }

    class Solution {
        public int uniquePaths(int m, int n) {
            if (m == 1 && n == 1) {
                return 1;
            }
            if (m == 1 || n == 1) {
                return 1;
            }

            return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        }

        public long uniquePaths1(int m, int n) {
            m = m - 1;
            n = n - 1;
            m = m + n;
            return C(m, n);
        }

        /**
         * C(n,m) = A(n,m) / m!; n >= m
         * 
         * @param n
         * @param m
         * @return
         */
        private long C(int n, int m) {
            long r = 1;
            int max = n - m > m ? n - m : m;

            for (int i = n; i > max; i--) {
                r *= i;
            }
            if (m == max) {
                m = n - m;
            }
            for (int i = m; i > 0; i--) {
                r /= i;
            }
            return r;
        }
    }
}
