package com.wei.leetcode.problem;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wei wang
 * @date 2020/08/03
 */
public class P50Pow {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        double x = 2;
        int n = Integer.MIN_VALUE;
        System.out.println(x + " : " + n);
        System.out.println(new P50Pow().new Solution().myPow(x, n));
    }

    class Solution {
        public double myPow(double x, int n) {
            if (n == 0) {
                return 1;
            }
            if (x == 1.0) {
                return 1;
            }
            if (x == 0.0) {
                return 0;
            }

            boolean negative = (n < 0);
            double result = 1;
            if (negative) {
                if (n == Integer.MIN_VALUE) {
                    result = 1 / x;
                    n += 1;
                }
                n = -1 * n;
            }

            // 0 1 2 3 4 5 6 7 8 9 2^(i-1)
            // 1 x x2 x4 x8 x16 x32 x64 x128 x256 x^(2^(i-1))
            List<Item> pow = new LinkedList<>();
            pow.add(new Item(1, 0));

            int m = 1;
            int max = Integer.MAX_VALUE / 2;
            while (m <= n && m < max) {
                System.out.println(n + " : " + m + " : " + max);
                pow.add(new Item(x, m));
                x *= x;
                m += m;
            }

            while (n > 0) {
                Item item = pow.get(pow.size() - 1);
                result *= item.val;
                n -= item.n;
                while (pow.size() > 0 && n < pow.get(pow.size() - 1).n) {
                    pow.remove(pow.size() - 1);
                }
            }

            return negative ? 1 / result : result;
        }
    }

    class Item {
        double val;
        int n;

        public Item(double val, int n) {
            this.val = val;
            this.n = n;
        }

    }
}
