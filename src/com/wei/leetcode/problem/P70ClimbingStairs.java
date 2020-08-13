package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/08/11
 */
public class P70ClimbingStairs {

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new P70ClimbingStairs().new Solution().climbStairs(i));
        }
    }

    class Solution {
        public int climbStairs(int n) {
            if (n < 3) {
                return n;
            }

            int[] stair = new int[n + 1];
            stair[0] = 0;
            stair[1] = 1;
            stair[2] = 2;

            for (int i = 3; i <= n; i++) {
                stair[i] = stair[i - 1] + stair[i - 2];
            }
            return stair[n];
        }
    }
}
