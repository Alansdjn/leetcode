package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/08/26
 */
public class P97InterleavingString {

    /**
     * @param args
     */
    public static void main(String[] args) {

        //String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
        System.out.println(new P97InterleavingString().new Solution().isInterleave(s1, s2, s3));

    }

    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1.length() + s2.length() != s3.length()) {
                return false;
            }

            return isInterleave(s1, 0, s2, 0, s3, 0);
        }

        public boolean isInterleave(String s1, int i1, String s2, int i2, String s3, int i3) {
            if (i3 == s3.length()) {
                return true;
            }

            if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3) && isInterleave(s1, i1 + 1, s2, i2, s3, i3 + 1)) {
                return true;
            }

            if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3) && isInterleave(s1, i1, s2, i2 + 1, s3, i3 + 1)) {
                return true;
            }

            return false;
        }
    }
}
