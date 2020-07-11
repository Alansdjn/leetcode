package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/07/07
 */
public class P8StringtoInteger {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String str = "-91283472332";
        System.out.println("Input: " + str + "\nOutput: " + new P8StringtoInteger().new Solution().myAtoi(str));

    }

    class Solution {
        public int myAtoi(String str) {
            int sign = 1;
            long result = 0;
            int i = 0;

            // skip white space
            for (; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == ' ') {
                    continue;
                }
                break;
            }

            // find sign
            for (; i < str.length();) {
                char ch = str.charAt(i);
                if (ch == '+' || ch == '-') {
                    sign = (ch == '-') ? -1 : 1;
                    i++;
                }
                break;
            }

            // find number
            for (; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch < '0' || ch > '9') {
                    break;
                }
                result = result * 10 + (ch - '0');
                if (sign * result > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (sign * result < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
            return (int)(sign * result);
        }
    }
}
