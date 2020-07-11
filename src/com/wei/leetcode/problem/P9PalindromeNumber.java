package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/07/07
 */
public class P9PalindromeNumber {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int x = 21112;
        System.out.println("Input: " + x + "\nOutput: " + new P9PalindromeNumber().new Solution().isPalindrome(x));
    }

    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }

            int y = 0;
            for (int i = x; i != 0; i /= 10) {
                y = y * 10 + i % 10;
            }

            return x == y;
        }
    }
}
