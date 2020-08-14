package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/08/13
 */
public class P72EditDistance {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String word1 = "";
        String word2 = "aaa";
        new P72EditDistance().new Solution().minDistance(word1, word2);
    }

    class Solution {
        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];

            for (int i = 0; i <= word1.length(); i++) {
                dp[i][0] = i;
            }
            for (int j = 0; j <= word2.length(); j++) {
                dp[0][j] = j;
            }

            for (int i = 0; i < word1.length(); i++) {
                char c1 = word1.charAt(i);
                for (int j = 0; j < word2.length(); j++) {
                    dp[i + 1][j + 1] =
                        eq(c1, word2.charAt(j)) ? dp[i][j] : min(dp[i][j], dp[i + 1][j], dp[i][j + 1]) + 1;
                }
            }

            for (int i = 0; i <= word1.length(); i++) {
                for (int j = 0; j <= word2.length(); j++) {
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }

            return dp[word1.length()][word2.length()];
        }

        private boolean eq(char c1, char c2) {
            return c1 == c2;
        }

        private int min(int a, int b, int c) {
            int min = a > b ? b : a;
            min = min > c ? c : min;
            return min;
        }
    }
}
