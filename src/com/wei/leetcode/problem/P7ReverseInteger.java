package com.wei.leetcode.problem;

public class P7ReverseInteger {

    public static void main(String[] args) {
        int x = 0;
        System.out.println("Input: " + x + "\nOutput: " + new P7ReverseInteger().new Solution().reverse(x));

    }

    class Solution {
        public int reverse(int x) {

            boolean neg = (x < 0);
            StringBuilder sb = new StringBuilder(neg ? "-" : "0");
            for (; x != 0; x /= 10) {
                sb.append(Math.abs(x % 10) + "");
            }

            long result = Long.parseLong(sb.toString());
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                result = 0L;
            }

            return (int)result;
        }
    }
}
