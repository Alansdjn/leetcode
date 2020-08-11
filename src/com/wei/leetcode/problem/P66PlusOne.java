package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/08/10
 */
public class P66PlusOne {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] digits = {9, 9, 9, 9, 9, 9};
        int[] r = new P66PlusOne().new Solution().plusOne(digits);
        for (int i = 0; i < r.length; i++) {
            System.out.print(r[i] + " ");
        }

    }

    class Solution {
        public int[] plusOne(int[] digits) {
            int carry = 1;

            int i = digits.length - 1;
            while (carry == 1 && i >= 0) {
                digits[i] += carry;
                carry = digits[i] / 10;
                digits[i] = digits[i] % 10;
                i--;
            }

            if (carry == 0) {
                return digits;
            } else {
                int[] r = new int[digits.length + 1];
                r[0] = 1;
                for (int j = 1; j < r.length; j++) {
                    r[j] = digits[j - 1];
                }
                return r;
            }
        }
    }
}
