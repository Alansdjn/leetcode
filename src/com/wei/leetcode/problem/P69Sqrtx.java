package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/08/11
 */
public class P69Sqrtx {

    /**
     * @param args
     */
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        for (int i = 1; i < 1000; i++) {
            System.out.print("i: " + i + " => " + new P69Sqrtx().new Solution().mySqrt1(i));
            System.out.println(" " + (int)Math.sqrt(i));
        }
        System.out.println(System.currentTimeMillis() - begin);
    }

    class Solution {
        public int mySqrt(int x) {
            long sq = 0;
            long max = x;
            for (long i = 1; i <= max; i++) {
                sq = i * i;
                if (sq < max) {
                    continue;
                }
                if (sq == max) {
                    return (int)i;
                }
                return (int)(i - 1);
            }

            return 0;
        }

        public int mySqrt1(int x) {
            int min = 0;
            int max = x;
            if (x < 3) {
                return 1;
            }
            while (min + 1 < max) {
                int mid = (max + min) / 2;
                int root = x / mid;
                if (root == mid) {
                    return mid;
                }
                if (root < mid) {
                    max = mid;
                } else {
                    min = mid;
                }
            }

            return min;
        }

    }
}
