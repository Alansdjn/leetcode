package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/08/10
 */
public class P67AddBinary {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String a = "100";
        String b = "110010";
        System.out.println(new P67AddBinary().new Solution().addBinary(a, b));
    }

    class Solution {
        public String addBinary(String a, String b) {
            int minLength = a.length() > b.length() ? b.length() : a.length();
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= minLength; i++) {
                int val = a.charAt(a.length() - i) + b.charAt(b.length() - i) + carry - 2 * '0';
                carry = val >= 2 ? 1 : 0;
                val = val >= 2 ? val - 2 : val;
                sb.insert(0, val);
            }
            for (int i = minLength; i < a.length(); i++) {
                int val = a.charAt(a.length() - i - 1) + carry - '0';
                carry = val >= 2 ? 1 : 0;
                val = val >= 2 ? val - 2 : val;
                sb.insert(0, val);
            }
            for (int i = minLength; i < b.length(); i++) {
                int val = b.charAt(b.length() - i - 1) + carry - '0';
                carry = val >= 2 ? 1 : 0;
                val = val >= 2 ? val - 2 : val;
                sb.insert(0, val);
            }
            if (carry == 1) {
                sb.insert(0, carry);
            }
            return sb.toString();
        }
    }
}
