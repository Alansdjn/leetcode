package com.wei.leetcode.problem;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * Input: "babad" Output: "bab" Note: "aba" is also a valid answer. Example 2:
 * 
 * Input: "cbbd" Output: "bb"
 * 
 * @author wei wang
 * @date 2020/03/21
 */
public class P5LongestPalindromicSubstring {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s = "";
        System.out.println(
            " Output: " + new P5LongestPalindromicSubstring().new Solution().longestPalindrome(s) + "\n Excepted: ");

    }

    class Solution {
        public String longestPalindrome(String s) {
            
            int n = s.length();
            int[][] T = new int[n][n];
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    int j = i + k;
                    if (j >= n) {
                        break;
                    }
                    if (k == 0) {
                        T[i][j] = 1;
                    }
                    if (k == 1) {
                        T[i][j] = (s.charAt(i) == s.charAt(j)) ? 1 : 0;
                    }
                    if (k > 1) {
                        T[i][j] = (T[i + 1][j - 1] == 1 && s.charAt(i) == s.charAt(j)) ? 1 : 0;
                    }
                }
            }

            int begin = 0;
            int end = -1;
            int length = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if (T[i][j] == 1 && length < (j - i + 1)) {
                        length = j - i + 1;
                        begin = i;
                        end = j;
                    }
                }
            }

            return s.substring(begin, end + 1);
        }
    }

}
